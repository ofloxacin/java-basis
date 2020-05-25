package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-25
 */
public class P0145_BinaryTreePostorderTraversal {

    @Test
    public void test() {
        TreeNode treeNode3 = new TreeNode(3, null, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode3, null);
        TreeNode treeNode1 = new TreeNode(1, null, treeNode2);

        Solution solution = new Solution3();
        System.out.println(solution.postorderTraversal(treeNode1));
    }

    /**
     * 递归
     */
    class Solution1 implements Solution {

        @Override
        public List<Integer> postorderTraversal(TreeNode root) {
            LinkedList<Integer> result = new LinkedList<>();
            access(root, result);
            return result;
        }

        private void access(TreeNode node, List<Integer> result) {
            if (node == null) {
                return;
            }
            access(node.left, result);
            access(node.right, result);
            result.add(node.val);
        }
    }

    /**
     * 栈
     */
    class Solution2 implements Solution {

        @Override
        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) {
                return new LinkedList<>();
            }
            LinkedList<Integer> result = new LinkedList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                result.addFirst(node.val);
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
            return result;
        }
    }

    /**
     * 莫里斯
     */
    class Solution3 implements Solution {

        @Override
        public List<Integer> postorderTraversal(TreeNode root) {
            LinkedList<Integer> result = new LinkedList<>();
            TreeNode node = new TreeNode(-1, root, null);
            while (node != null) {
                if (node.left == null) {
                    node = node.right;
                    continue;
                }
                TreeNode predecessor = node.left;
                while (predecessor.right != null && predecessor.right != node) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = node;
                    node = node.left;
                } else {
                    predecessor.right = null;
                    addResult(node.left, result);
                    node = node.right;
                }
            }
            return result;
        }

        private void addResult(TreeNode node, LinkedList<Integer> result) {
            TreeNode tail = reverseNode(node);
            TreeNode cur = tail;
            while (cur != null) {
                result.add(cur.val);
                cur = cur.right;
            }
            reverseNode(tail);
        }

        private TreeNode reverseNode(TreeNode node) {
            TreeNode pre = null;
            TreeNode next = null;
            while (node != null) {
                next = node.right;
                node.right = pre;
                pre = node;
                node = next;
            }
            return pre;
        }
    }

    interface Solution {

        List<Integer> postorderTraversal(TreeNode root);
    }

    public class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }
}
