// Question: https://leetcode.com/problems/find-eventual-safe-states/description/

class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        int len = graph.length;
        int[] visited = new int[len];
        boolean isTest = false;

        for (int i = 0; i < len; i++) {
            if (isSafe(i, graph, visited)) {
                result.add(i);
            }
        }
        if (isTest) {
            System.out.println("graph:");
            for (int i = 0; i < len; i++) {
                System.out.println(" * vertex " + i + " -> " + Arrays.toString(graph[i]));
            }
            System.out.println("--------------------------------------------------------");
            System.out.println("visited: " + Arrays.toString(visited));
        }

        return result;
    }

    private boolean isSafe(int i, int[][] graph, int[] visited) {
        // 1. Current path is a cycle, hence it has no terminal node.
        if (visited[i] == 1) {
            return false;
        }

        // 2. Current path has a terminal node, so its root vertex is safe.
        if (visited[i] == 2) {
            return true;
        }

        // 3. Mark current node as visited but ongoing checks to do.
        visited[i] = 1;

        // 4. Visit unvisited neighbours of i and return false if current path is a cycle.
        for (int j: graph[i]) {
            if (!isSafe(j, graph, visited)) {
                return false;
            }
        }

        // 5. Vertex i is safe because it forms a path that leads to a terminal path.
        visited[i] = 2;

        return true;
    }
}