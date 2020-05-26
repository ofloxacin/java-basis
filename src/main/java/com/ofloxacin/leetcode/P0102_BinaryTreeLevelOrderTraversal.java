package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-26
 */
public class P0102_BinaryTreeLevelOrderTraversal {

    @Test
    public void test() {
        TreeNode n5 = new TreeNode(7, null, null);
        TreeNode n4 = new TreeNode(15, null, null);
        TreeNode n3 = new TreeNode(20, n4, n5);
        TreeNode n2 = new TreeNode(9, null, null);
        TreeNode n1 = new TreeNode(3, n2, n3);

        Solution solution = new Solution1();
        System.out.println(solution.levelOrder(n1));
    }

    class Solution1 implements Solution {

        @Override
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new LinkedList<>();
            }
            List<List<Integer>> result = new LinkedList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int n = queue.size();
                LinkedList<Integer> layerValues = new LinkedList<>();
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll();
                    layerValues.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                result.add(layerValues);
            }
            return result;
        }
    }

    interface Solution {

        List<List<Integer>> levelOrder(TreeNode root);
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
