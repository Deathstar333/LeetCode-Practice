package org.practice.trees;

public class q98 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    /*  Time Complexity = O(N) N is number of nodes
        Space Complexity = O(N) Function call stack grows to N for skewed tree
    */
    class Solution {
        public boolean isValidBST(TreeNode root) {
            if(root == null) return true;
            int v = root.val;
            return dfs(root.left, Long.MIN_VALUE, v) && dfs(root.right, v, Long.MAX_VALUE);
        }

        public boolean dfs(TreeNode root, long lower, long upper) {
            if(root == null) return true;
            int v = root.val;
            if(v <= lower || v >= upper) return false;
            return dfs(root.left, lower, v) && dfs(root.right, v, upper);
        }
    }
}
