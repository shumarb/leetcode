// Question: https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/

class CountUnreachablePairsOfNodesInAnUndirectedGraph {
    private List<Integer>[] graph;
    private boolean[] isVisited;

    public long countPairs(int n, int[][] edges) {
        List<Integer> nodeComponentSizes = new ArrayList<>();
        boolean isTest = false;
        long remaining = n;
        long result = 0;
        graph = new ArrayList[n];
        isVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
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
            System.out.println("----------------------------------------------------");
        }

        /**
         1.  For each node, compute number of nodes it is directly and undirectly connected to.
         Then use this amount to compute number of nodes it is not connected to
         */
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                int componentSize = bfs(i);
                nodeComponentSizes.add(componentSize);
                if (isTest) {
                    System.out.println(" * source: " + i + " | component size: " + componentSize);
                }
            }
        }

        /**
         2.  Remaining tracks number of nodes left a node is not connected to.
         Multiply remaining with size to count number of unconnected pairs.
         */
        for (int size: nodeComponentSizes) {
            remaining -= size;
            result += (remaining * size);
        }
        if (isTest) {
            System.out.println("----------------------------------------------------\nresult: " + result);
        }

        return result;
    }

    private int bfs(int source) {
        Queue<Integer> queue = new LinkedList<>();
        int size = 0;

        queue.offer(source);
        isVisited[source] = true;

        while (!queue.isEmpty()) {
            int top = queue.poll();
            size++;

            for (int neighbour: graph[top]) {
                if (!isVisited[neighbour]) {
                    isVisited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }

        return size;
    }
}
