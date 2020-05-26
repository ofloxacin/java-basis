package com.ofloxacin.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author chenshuai
 * @version 0.1
 * @description
 * @date 2020-05-26
 */
public class P0110_BalancedBinaryTree {

    @Test
    public void test() {
        TreeNode n5 = new TreeNode(7, null, null);
        TreeNode n4 = new TreeNode(15, null, null);
        TreeNode n3 = new TreeNode(20, n4, n5);
        TreeNode n2 = new TreeNode(9, null, null);
        TreeNode n1 = new TreeNode(3, n2, n3);

        TreeNode n16 = new TreeNode(4, null, null);
        TreeNode n17 = new TreeNode(4, null, null);
        TreeNode n14 = new TreeNode(3, n16, n17);
        TreeNode n15 = new TreeNode(3, null, null);
        TreeNode n12 = new TreeNode(2, n14, n15);
        TreeNode n13 = new TreeNode(2, null, null);
        TreeNode n11 = new TreeNode(1, n12, n13);

        Solution solution = new Solution3();
        System.out.println(solution.isBalanced(n1));
        System.out.println(solution.isBalanced(n11));
    }

    class Solution1 implements Solution {

        @Override
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            return Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
        }

        private int height(TreeNode node) {
            if (node == null) {
                return -1;
            }
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }

    class Solution2 implements Solution {

        @Override
        public boolean isBalanced(TreeNode root) {
            return helper(root).balanced;
        }

        private TreeInfo helper(TreeNode node) {
            if (node == null) {
                return new TreeInfo(-1, true);
            }
            TreeInfo left;
            TreeInfo right;
            if (!(left = helper(node.left)).balanced
                    || !(right = helper(node.right)).balanced
                    || Math.abs(left.height - right.height) > 1) {
                return new TreeInfo(-1, false);
            }
            return new TreeInfo(Math.max(left.height, right.height) + 1, true);
        }

        class TreeInfo {

            int height;

            boolean balanced;

            public TreeInfo(int height, boolean balanced) {
                this.height = height;
                this.balanced = balanced;
            }
        }
    }

    class Solution3 implements Solution {

        @Override
        public boolean isBalanced(TreeNode root) {
            return helper(root) != -1;
        }

        private int helper(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int left, right;
            if ((left = helper(node.left)) == -1
                    || (right = helper(node.right)) == -1
                    || Math.abs(left - right) > 1) {
                return -1;
            }
            return Math.max(left, right) + 1;
        }
    }

    interface Solution {

        boolean isBalanced(TreeNode root);
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
