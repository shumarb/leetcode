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
    private List<int[]> pairs = new ArrayList<>();
    private int maximumLevel = Integer.MIN_VALUE;

    public List<List<Integer>> levelOrder(Node root) {
        boolean isTest = false;

        levelOrderTraversal(root, 0);
        if (isTest) {
            System.out.println("maximum level: " + maximumLevel);
            System.out.println("pairs: ");
            for (int[] pair: pairs) {
                System.out.println(" * node: " + pair[0] + " -> level: " + pair[1]);
            }
        }
        List<List<Integer>> result = new ArrayList<>();

        int currentLevel = 0;
        while (currentLevel <= maximumLevel) {
            List<Integer> list = new ArrayList<>();
            for (int[] pair: pairs) {
                if (pair[1] == currentLevel) {
                    list.add(pair[0]);
                }
            }
            result.add(list);
            currentLevel++;
        }
        if (isTest) {
            System.out.println("result: ");
            for (List<Integer> path: result) {
                System.out.println(" * " + path);
            }
        }
        return result;
    }

    private void levelOrderTraversal(Node node, int level) {
        if (node != null) {
            int[] newPair = new int[] {node.val, level};
            pairs.add(newPair);
            maximumLevel = Math.max(maximumLevel, level);
            for (Node child: node.children) {
                if (child != null) {
                    levelOrderTraversal(child, level + 1);
                }
            }
        }
    }
}