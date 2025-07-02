// Question: https://leetcode.com/problems/all-paths-from-source-to-target/description/

class AllPathsFromSourceToTarget {
    private List<List<Integer>> pathsFromSourceToTarget;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean isTest = false;
        pathsFromSourceToTarget = new ArrayList<>();

        dfs(0, new ArrayList<>(), new boolean[graph.length], graph);
        if (isTest) {
            System.out.println("graph:");
            for (int i = 0; i < graph.length; i++) {
                System.out.println(i + " -> neighbours: " + Arrays.toString(graph[i]));
            }
            System.out.println("-------------------------------------------------------");
            System.out.println("pathsFromSourceToTarget:");
            for (List<Integer> path: pathsFromSourceToTarget) {
                System.out.println(path);
            }
        }

        return pathsFromSourceToTarget;
    }

    private void dfs(int current, List<Integer> path, boolean[] isVisited, int[][] graph) {
        // 1. Add current to path and mark it as visited.
        path.add(current);

        // 2. Add path to pathsFromSourceToTarget if current == target.
        if (current == graph.length - 1) {
            pathsFromSourceToTarget.add(new ArrayList<>(path));
        } else {
            // 3. Execute dfs on unvisited neighbours of current vertex.
            for (int neighbour: graph[current]) {
                if (!isVisited[neighbour]) {
                    dfs(neighbour, path, isVisited, graph);
                }
            }
        }

        // 4. Backtrack.
        isVisited[current] = false;
        path.removeLast();
    }
}