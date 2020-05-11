package org.practice.trees;

public class q297 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    /*
        Time Complexity: O(N)
        Space Complexity: O(N)
     */
    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            dfs(root, sb);
            System.out.println(sb.toString());
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Deque<String> nodes = new LinkedList<>();
            nodes.addAll(Arrays.asList(data.split(",")));
            //System.out.println(Arrays.toString(str));
            return buildTree(nodes);
        }

        public void dfs(TreeNode node, StringBuilder sb) {
            if(node == null) {
                sb.append("n").append(",");
                return;
            }

            sb.append(node.val).append(",");
            dfs(node.left, sb);
            dfs(node.right, sb);
        }

        public TreeNode buildTree(Deque<String> nodes) {
            String str = nodes.remove();
            if(str.equals("n")) return null;
            else {
                TreeNode node = new TreeNode(Integer.parseInt(str));
                node.left = buildTree(nodes);
                node.right = buildTree(nodes);
                return node;
            }
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

// pre: 1 2 n n 3 4 n n 5 n n
}
