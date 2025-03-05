// Question: https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/

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
}
*/

class NAryTreePostOrderTraversal {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        traverse(root);
        return result;
    }

    private void traverse(Node node) {
        if (node != null) {
            for (Node child: node.children) {
                if (child != null) {
                    traverse(child);
                }
            }
            result.add(node.val);
        }
    }
}