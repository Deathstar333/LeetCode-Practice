package org.practice.trees;

public class q106 {
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            len = inorder.length;
            if(len == 0) return null;
            map = new HashMap<>();
            k = len-1;
            for(int i=0; i<len; i++) {
                map.put(inorder[i], i);
            }
            return constructBTree(inorder, postorder, 0, len-1);
        }

        public TreeNode constructBTree(int[] inorder, int[] postorder, int i, int j) {
            if(k < 0) return null;
            int val = postorder[k];
            int index = map.get(val);
            if(index < i || index > j) {
                k++;
                return null;
            }
            TreeNode node = new TreeNode(inorder[index]);
            k--;
            node.right = constructBTree(inorder, postorder, index+1, j);
            k--;
            node.left = constructBTree(inorder, postorder, i, index-1);
            return node;
        }
    }
}
