// Question: https://leetcode.com/problems/redundant-connection/description/

class RedundantConnection {
    private int countVisited;

    public int[] findRedundantConnection(int[][] edges) {
        Set<Integer>[] graph;
        int largest = 0;
        countVisited = 0;

        for (int[] edge: edges) {
            largest = Math.max(largest, Math.max(edge[0], edge[1]));
        }

        graph = new HashSet[largest + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] edge: edges) {
            int destination = edge[1];
            int source = edge[0];
            graph[source].add(destination);
            graph[destination].add(source);
        }
        for (int i = edges.length - 1; i >= 0; i--) {
            int[] edge = edges[i];
            int destination = edge[1];
            int source = edge[0];

            graph[source].remove(destination);
            graph[destination].remove(source);

            dfs(graph, 1, new boolean[largest + 1]);
            if (countVisited == largest) {
                return edge;
            }

            countVisited = 0;
            graph[source].add(destination);
            graph[destination].add(source);
        }

        return new int[] {-1, -1};
    }

    private void dfs(Set<Integer>[] graph, int vertex, boolean[] isVisited) {
        isVisited[vertex] = true;
        countVisited++;

        for (int destination: graph[vertex]) {
            if (!isVisited[destination]) {
                dfs(graph, destination, isVisited);
            }
        }
    }
}
