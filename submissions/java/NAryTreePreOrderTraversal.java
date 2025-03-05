// Question: https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/

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

class NAryTreePreOrderTraversal {
    List<Integer> result = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        preOrderTraversal(root);
        return result;
    }

    private void preOrderTraversal(Node node) {
        if (node != null) {
            result.add(node.val);
            for (Node child: node.children) {
                if (child != null) {
                    preOrderTraversal(child);
                }
            }
        }
    }
}