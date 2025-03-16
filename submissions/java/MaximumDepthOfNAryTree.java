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
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int maximumLevel = 0;
        for (Node child: root.children) {
            maximumLevel = Math.max(maximumLevel, maxDepth(child));
        }

        return maximumLevel + 1;
    }
}