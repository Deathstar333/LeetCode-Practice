package org.practice.trees;

public class q105 {
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

    /*
        Time Complexity: O(N)
        Space Complexity: O(N)
        N is number of nodes in tree
     */
    class Solution {
        HashMap<Integer, Integer> map;
        int k, len;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            len = inorder.length;
            if(len == 0) return null;
            map = new HashMap<>();
            k = 0;
            for(int i=0; i<len; i++) {
                map.put(inorder[i], i);
            }
            return constructBTree(preorder, inorder, 0, len-1);
        }

        public TreeNode constructBTree(int[] preorder, int[] inorder, int i, int j) {
            if(k >= len) return null;
            int val = preorder[k];
            int index = map.get(val);
            if(index < i || index > j) {
                k--;
                return null;
            }
            TreeNode node = new TreeNode(inorder[index]);
            k++;
            node.left = constructBTree(preorder, inorder, i, index-1);
            k++;
            node.right = constructBTree(preorder, inorder, index+1, j);
            return node;
        }
    }
}
