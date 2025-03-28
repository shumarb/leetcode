// Question: https://leetcode.com/problems/maximum-depth-of-n-ary-tree/description/

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

class MaximumDepthOfNAryTree {
    private int maximumDepth = 0;

    public int maxDepth(Node root) {
        dfs(root, 1);
        return maximumDepth;
    }

    private void dfs(Node node, int currentDepth) {
        if (node == null) {
            return;
        }
        maximumDepth = Math.max(maximumDepth, currentDepth);
        for (Node child: node.children) {
            dfs(child, 1 + currentDepth);
        }
    }
}