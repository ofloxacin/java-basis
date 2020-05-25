package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-25
 */
public class P0094_BinaryTreeInorderTraversal {

    @Test
    public void test() {
        TreeNode treeNode3 = new TreeNode(3, null, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode3, null);
        TreeNode treeNode1 = new TreeNode(1, null, treeNode2);

        Solution solution = new Solution3();
        System.out.println(solution.inorderTraversal(treeNode1));
    }

    interface Solution {

        List<Integer> inorderTraversal(TreeNode root);
    }

    /**
     * 递归
     */
    class Solution1 implements Solution {

        @Override
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            access(root, result);
            return result;
        }

        public void access(TreeNode node, List<Integer> result) {
            if (node == null) {
                return;
            }
            access(node.left, result);
            result.add(node.val);
            access(node.right, result);
        }
    }

    /**
     * 栈
     */
    class Solution2 implements Solution {

        @Override
        public List<Integer> inorderTraversal(TreeNode root) {
            LinkedList<Integer> result = new LinkedList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
            return result;
        }
    }

    /**
     * 莫里斯
     */
    class Solution3 implements Solution {

        @Override
        public List<Integer> inorderTraversal(TreeNode root) {
            LinkedList<Integer> result = new LinkedList<>();
            TreeNode node = root;
            while (node != null) {
                if (node.left == null) {
                    result.add(node.val);
                    node = node.right;
                    continue;
                }
                TreeNode prev = node.left;
                while (prev.right != null && prev.right != node) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    // 第一次到达左子树的最右端
                    prev.right = node;
                    node = node.left;
                } else {
                    // 第二次到达左子树的最右端
                    result.add(node.val);
                    prev.right = null;
                    node = node.right;
                }
            }
            return result;
        }
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
