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
        List<Integer>[] graph = new ArrayList[501];
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited;
        boolean isTest = false;
        int level = -1;
        largest = 0;

        dfs(graph, root);
        if (isTest) {
            System.out.println("graph:");
            for (int i = 0; i <= largest; i++) {
                System.out.println(" * " + i + " -> " + graph[i]);
            }
            System.out.println("-------------------------------------------------------------------------------");
        }

        queue.offer(target.val);
        isVisited = new boolean[largest +1];
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++level;
            if (isTest) {
                System.out.println("level: " + level + " -> queue: " + queue);
                System.out.println("-------------------------------------------------------------------------------");
            }

            if (level == k) {
                return new ArrayList<>(queue);
            }
            for (int i = 0; i < size; i++) {
                int top = queue.poll();
                isVisited[top] = true;

                for (int neighbour: graph[top]) {
                    if (!isVisited[neighbour]) {
                        queue.offer(neighbour);
                    }
                }
            }
        }
        if (isTest) {
            System.out.println("largest: " + largest);
            System.out.print("isVisited: [");
            for (int i = 0; i < isVisited.length - 1; i++) {
                System.out.print(isVisited[i] + ", ");
            }
            System.out.println(isVisited[largest] + "]\nresult: " + result);
        }

        return result;
    }

    private void dfs(List<Integer>[] graph, TreeNode node) {
        if (node == null) {
            return;
        }

        largest = Math.max(largest, node.val);
        if (graph[node.val] == null) {
            graph[node.val] = new ArrayList<>();
        }

        if (node.left != null) {
            if (graph[node.left.val] == null) {
                graph[node.left.val] = new ArrayList<>();
            }
            graph[node.left.val].add(node.val);
            graph[node.val].add(node.left.val);
        }

        if (node.right != null) {
            if (graph[node.right.val] == null) {
                graph[node.right.val] = new ArrayList<>();
            }
            graph[node.right.val].add(node.val);
            graph[node.val].add(node.right.val);
        }

        if (node.left != null) {
            dfs(graph, node.left);
        }
        if (node.right != null) {
            dfs(graph, node.right);
        }
    }
}
