// Question: https://leetcode.com/problems/all-paths-from-source-to-target/description/

class AllPathsFromSourceToTarget {
    private List<List<Integer>> pathsFromSourceToTarget;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean isTest = false;
        pathsFromSourceToTarget = new ArrayList<>();

        dfs(0, graph.length - 1, new ArrayList<>(), graph);
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

    private void dfs(int current, int destination, List<Integer> path, int[][] graph) {
        // 1. Add current to path and mark it as visited.
        path.add(current);

        // 2. Add path to pathsFromSourceToTarget if destination is reached.
        if (current == destination) {
            pathsFromSourceToTarget.add(new ArrayList<>(path));
            return;
        }

        for (int neighbour: graph[current]) {
            dfs(neighbour, destination, path, graph);
            path.removeLast();
        }
    }
}