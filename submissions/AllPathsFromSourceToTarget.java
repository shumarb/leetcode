// Question: https://leetcode.com/problems/all-paths-from-source-to-target/description/

class AllPathsFromSourceToTarget {
    private List<List<Integer>> pathsFromSourceToTarget = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean isTest = false;

        dfs(0, graph, new ArrayList<>());
        if (isTest) {
            System.out.println("graph:");
            for (int[] row: graph) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("------------------------------------");
            System.out.println("result:");
            for (List<Integer> path: pathsFromSourceToTarget) {
                System.out.println(path);
            }
            System.out.println("------------------------------------");
        }

        return pathsFromSourceToTarget;
    }

    private void dfs(int current, int[][] graph, List<Integer> path) {
        // 1. Add current vertex to existing path.
        path.add(current);

        // 2. If current vertex is destination, add path to result.
        if (current == graph.length - 1) {
            pathsFromSourceToTarget.add(new ArrayList<>(path));
        } else {
            // 3. If current vertex is not destination, execute dfs on its neighbours
            for (int neighbour: graph[current]) {
                dfs(neighbour, graph, path);
            }
        }

        // 4. Backtrack.
        path.remove(path.size() - 1);
    }
}