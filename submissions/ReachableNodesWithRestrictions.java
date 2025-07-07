// Question: https://leetcode.com/problems/reachable-nodes-with-restrictions/description/

class ReachableNodesWithRestrictions {
    private List<Integer>[] graph;
    private boolean[] isVisitedOrRestricted;
    private int count;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean isTest = false;
        graph = new List[n];
        isVisitedOrRestricted = new boolean[n];
        count = 0;

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int node: restricted) {
            isVisitedOrRestricted[node] = true;
        }
        for (int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        if (isTest) {
            System.out.println("graph:");
            for (int i = 0; i < graph.length; i++) {
                System.out.println(" * " + i + " -> " + graph[i]);
            }
            System.out.println("------------------------");
        }

        dfs(0, isVisitedOrRestricted, graph);
        if (isTest) {
            System.out.println("count: " + count);
        }

        return count;
    }

    private void dfs(int i, boolean[] isVisitedOrRestricted, List<Integer>[] graph) {
        isVisitedOrRestricted[i] = true;
        count++;
        for (int neighbour: graph[i]) {
            if (!isVisitedOrRestricted[neighbour]) {
                dfs(neighbour, isVisitedOrRestricted, graph);
            }
        }
    }
}