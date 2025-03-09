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
        // 1. Empty tree.
        if (root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(root);

        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();
                if (currentNode.children != null) {
                    for (Node child: currentNode.children) {
                        queue.offer(child);
                    }
                }
            }
        }

        return depth;
    }
}