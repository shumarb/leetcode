// Question: https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/

class CountUnreachablePairsOfNodesInAnUndirectedGraph {
    private List<List<Integer>> graph;
    private boolean[] isVisited;

    public long countPairs(int n, int[][] edges) {
        List<Integer> nodeComponentSizes = new ArrayList<>();
        boolean isTest = false;
        long remaining = n;
        long result = 0;
        graph = new ArrayList<>();
        isVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            int first = edge[0];
            int second = edge[1];
            graph.get(first).add(second);
            graph.get(second).add(first);
        }
        if (isTest) {
            System.out.println("graph:");
            for (int i = 0; i < graph.size(); i++) {
                System.out.println(" * " + i + " -> " + graph.get(i));
            }
        }

        /**
         1.  For each node, compute number of nodes it is directly and undirectly connected to.
         Then use this amount to compute number of nodes it is not connected to
         */
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                nodeComponentSizes.add(bfs(i));
            }
        }
        if (isTest) {
            System.out.println("--------------------------\nnodeComponentSizes: ");
            for (int i = 0; i < nodeComponentSizes.size(); i++) {
                System.out.println(" * node " + i + " -> " + nodeComponentSizes.get(i));
            }
        }

        /*
            2.  Remaining tracks number of nodes left a node is not connected to.
                Multiply remaining with size to count number of unconnected pairs.
        */
        for (int size: nodeComponentSizes) {
            remaining -= size;
            result += (remaining * size);
        }
        if (isTest) {
            System.out.println("--------------------------\nresult: " + result);
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

            for (int neighbour: graph.get(top)) {
                if (!isVisited[neighbour]) {
                    isVisited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }

        return size;
    }
}
