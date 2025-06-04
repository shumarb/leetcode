// Question: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        // 1. Empty tree.
        if (root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Node> nodesOnCurrentLevel = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                nodesOnCurrentLevel.add(current);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            if (nodesOnCurrentLevel.size() > 1) {
                update(nodesOnCurrentLevel);
            }
        }

        return root;
    }

    private void update(List<Node> nodesOnCurrentLevel) {
        for (int i = 0; i < nodesOnCurrentLevel.size() - 1; i++) {
            nodesOnCurrentLevel.get(i).next = nodesOnCurrentLevel.get(i + 1);
        }
    }
}