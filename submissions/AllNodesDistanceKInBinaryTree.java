// Question: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class AllNodesDistanceKInBinaryTree {
    private int largest;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited;
        boolean isTest = false;
        int level = -1;
        largest = 0;

        dfs(graph, root);
        if (isTest) {
            System.out.println("graph:");
            for (Map.Entry<Integer, List<Integer>> e: graph.entrySet()) {
                System.out.println(" * " + e.getKey() + " -> " + e.getValue());
            }
            System.out.println("-------------------------------------------------------------------------------");
        }

        isVisited = new boolean[largest + 1];
        queue.offer(target.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++level;
            if (isTest) {
                System.out.println("level: " + level + " -> queue: " + queue);
                System.out.println("-------------------------------------------------------------------------------");
            }

            if (level == k) {
                while (!queue.isEmpty()) {
                    result.add(queue.poll());
                }
                break;
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
            System.out.println("largest: " + largest + "\nisVisited: " + Arrays.toString(isVisited) + "\nresult: " + result);
        }

        return result;
    }

    private void dfs(Map<Integer, List<Integer>> graph, TreeNode node) {
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
            dfs(graph, node.left);
        }
        if (node.right != null) {
            dfs(graph, node.right);
        }
    }
}