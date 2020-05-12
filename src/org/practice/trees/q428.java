package org.practice.trees;

public class q428 {

    /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Codec {
        // Encodes a tree to a single string.
        public String serialize(Node root) {
            StringBuilder sb = new StringBuilder();
            buildString(root, sb);
            System.out.println(sb.toString());
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            Deque<String> nodes = new LinkedList<>();
            nodes.addAll(Arrays.asList(data.split(",")));
            return buildTree(nodes);
            // return null;
        }

        public void buildString(Node node, StringBuilder sb) {
            if(node == null) {
                sb.append("n").append(",");
                return;
            }
            else {
                sb.append(node.val).append(",");
                if(node.children.isEmpty()) {
                    buildString(null, sb);
                }
                else {
                    for(Node child: node.children) {
                        buildString(child, sb);
                    }
                    sb.append("x").append(",");
                }
            }

        }

        public Node buildTree(Deque<String> nodes) {
            if(nodes.isEmpty()) return null;
            String str = nodes.remove();
            System.out.println(str);
            if(str.equals("n")) {
                return null;
            }
            else {
                Node node = new Node(Integer.valueOf(str));
                while(!nodes.peek().equals("x")) {
                    Node child = buildTree(nodes);
                    if(child != null) node.children.add(child);
                }
                nodes.remove();
                return node;
            }
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
