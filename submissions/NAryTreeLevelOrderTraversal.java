// Question: https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/

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

class NAryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        // 1. Edge case: 0 nodes in tree.
        if (root == null) {
            return result;
        }

        boolean isTest = false;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            /**
             2.  All nodes in queue at start of iteration
             are all nodes at current level.
             */
            int nodesAtCurrentLevel = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < nodesAtCurrentLevel; i++) {
                /**
                 3.  Extract every node at current level,
                 and it to list node all nodes at current level.
                 */
                Node node = queue.poll();
                currentLevel.add(node.val);
                /**
                 4.  For every node at current level,
                 add its non-null child into queue.
                 */
                for (Node child: node.children) {
                    if (child != null) {
                        queue.offer(child);
                    }
                }
            }

            /**
             5.  All nodes at current level added to list,
             hence add this list to result.
             */
            result.add(currentLevel);
        }
        if (isTest) {
            System.out.println("result: ");
            /**
             6.  Each list comprises of all nodes level-by-level.
             */
            for (List<Integer> level: result) {
                System.out.println(" * " + level);
            }
        }

        return result;
    }
}