// Question: https://leetcode.com/problems/redundant-connection-ii/description/

class RedundantConnectionTwo {
    private int countVisitedNodes;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        Set<Integer>[] graph = new HashSet[1001];
        boolean isTest = false;
        int largest = 0;

        for (int[] edge: edges) {
            int destination = edge[1];
            int source = edge[0];

            largest = Math.max(largest, Math.max(destination, source));
            if (graph[destination] == null) {
                graph[destination] = new HashSet<>();
            }

            if (graph[source] == null) {
                graph[source] = new HashSet<>();
            }

            graph[source].add(destination);
        }
        if (isTest) {
            System.out.println("largest: " + largest);
            System.out.println("--------------------------------------------------\ngraph:");
            for (int i = 1; i <= largest; i++) {
                System.out.println(" * " + i + ": " + graph[i]);
            }
            System.out.println("--------------------------------------------------");
        }

        for (int i = edges.length - 1; i >= 0; i--) {
            int[] edge = edges[i];
            int destination = edge[1];
            int source = edge[0];

            graph[source].remove(destination);
            int root = getRoot(edges, i, largest);

            dfs(graph, root, new boolean[largest + 1]);
            if (isTest) {
                System.out.println(" * remove edge " + Arrays.toString(edge) + " -> root: " + root + ", countVisitedNodes: " + countVisitedNodes);
            }
            if (countVisitedNodes == largest) {
                if (isTest) {
                    System.out.println(" ** result: " + Arrays.toString(edge));
                }
                return edge;
            }
            countVisitedNodes = 0;
            graph[source].add(destination);
        }

        return new int[0];
    }

    private int getRoot(int[][] edges, int indexToIgnore, int largest) {
        int[] inDegree = new int[largest + 1];

        inDegree[0] = -1;
        for (int i = 0; i < edges.length; i++) {
            if (i == indexToIgnore) {
                continue;
            }
            int[] edge = edges[i];
            int destination = edge[1];
            inDegree[destination]++;
        }
        for (int i = 1; i <= largest; i++) {
            if (inDegree[i] == 0) {
                return i;
            }
        }

        return 1;
    }

    private void dfs(Set<Integer>[] graph, int source, boolean[] isVisited) {
        isVisited[source] = true;
        countVisitedNodes++;

        for (int destination: graph[source]) {
            if (!isVisited[destination]) {
                dfs(graph, destination, isVisited);
            }
        }
    }
}
