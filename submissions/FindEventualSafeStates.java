// Question: https://leetcode.com/problems/find-eventual-safe-states/description/

class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        boolean isTest = false;
        int len = graph.length;
        int[] safety = new int[len]; // 0: unvisted, 1: not confirmed; 2: safe.

        for (int i = 0; i < len; i++) {
            if (isSafe(i, graph, safety)) {
                result.add(i);
            }
        }
        if (isTest) {
            System.out.println("graph:");
            for (int i = 0; i < len; i++) {
                System.out.println(" * vertex " + i + " -> " + Arrays.toString(graph[i]));
            }
            System.out.println("--------------------------------------------------------");
            System.out.println("safety: " + Arrays.toString(safety));
            System.out.println("result: " + result);
        }

        return result;
    }

    private boolean isSafe(int i, int[][] graph, int[] safety) {
        // 1. Current path is a cycle, hence it has no terminal node.
        if (safety[i] == 1) {
            return false;
        }

        // 2. Current node is a terminal node.
        if (graph[i].length == 0) {
            safety[i] = 2;
            return true;
        }

        // 3. Current path has a terminal node, so its root vertex is safe.
        if (safety[i] == 2) {
            return true;
        }

        // 4. Mark current node as visited but ongoing checks to do.
        safety[i] = 1;

        // 5. Visit unvisited neighbours of i and return false if current path is a cycle.
        for (int j: graph[i]) {
            if (!isSafe(j, graph, safety)) {
                return false;
            }
        }

        // 6. Vertex i is safe because it forms a path that leads to a terminal path.
        safety[i] = 2;

        return true;
    }
}