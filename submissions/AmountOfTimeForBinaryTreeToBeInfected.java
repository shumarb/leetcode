// Question: https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class AmountOfTimeForBinaryTreeToBeInfected {
    private Map<Integer, List<Integer>> graph;
    private int largest;

    public int amountOfTime(TreeNode root, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited;
        boolean isTest = false;
        graph = new HashMap<>();
        int level = -1;
        largest = 0;

        dfs(root);
        if (isTest) {
            System.out.println("graph:");
            for (Map.Entry<Integer, List<Integer>> e: graph.entrySet()) {
                System.out.println(" * " + e.getKey() + " -> " + e.getValue());
            }
        }

        isVisited = new boolean[largest + 1];
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++level;
            if (isTest) {
                System.out.println("---------------------------------\nlevel: " + level + " -> queue: " + queue);
            }

            for (int i = 0; i < size; i++) {
                int top = queue.poll();
                isVisited[top] = true;
                List<Integer> neighbours = graph.get(top);
                for (int neighbour: neighbours) {
                    if (!isVisited[neighbour]) {
                        queue.offer(neighbour);
                    }
                }
            }
        }
        if (isTest) {
            System.out.println("---------------------------------\nisVisited: " + Arrays.toString(isVisited) + "\nlevel: " + level);
        }

        return level;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        largest = Math.max(largest, node.val);
        graph.putIfAbsent(node.val, new ArrayList<>());

        if (node.left != null) {
            graph.putIfAbsent(node.left.val, new ArrayList<>());
            graph.get(node.val).add(node.left.val);
            graph.get(node.left.val).add(node.val);
        }
        if (node.right != null) {
            graph.putIfAbsent(node.right.val, new ArrayList<>());
            graph.get(node.val).add(node.right.val);
            graph.get(node.right.val).add(node.val);
        }

        if (node.left != null) {
            dfs(node.left);
        }
        if (node.right != null) {
            dfs(node.right);
        }
    }
}