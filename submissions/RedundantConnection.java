// Question: https://leetcode.com/problems/redundant-connection/description/

class RedundantConnection {
    private boolean isTest;
    private int largest;

    public int[] findRedundantConnection(int[][] edges) {
        isTest = false;
        largest = 0;

        for (int[] edge: edges) {
            largest = Math.max(largest, Math.max(edge[0], edge[1]));
        }
        if (isTest) {
            System.out.println("largest: " + largest);
        }

        for (int i = edges.length - 1; i >= 0; i--) {
            if (isGraphWithAllNodes(edges, i)) {
                return edges[i];
            }
        }

        return new int[] {-1, -1};
    }

    private boolean isGraphWithAllNodes(int[][] edges, int indexToExclude) {
        List<Integer>[] graph = new ArrayList[largest + 1];
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[largest + 1];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            if (i == indexToExclude) {
                continue;
            }

            int destination = edges[i][1];
            int source = edges[i][0];
            graph[source].add(destination);
            graph[destination].add(source);
        }

        queue.offer(1);
        while (!queue.isEmpty()) {
            int source = queue.poll();
            isVisited[source] = true;

            for (int destination: graph[source]) {
                if (!isVisited[destination]) {
                    queue.offer(destination);
                }
            }
        }
        if (isTest) {
            System.out.println("indexToExclude: " + indexToExclude + " | isVisited: " + Arrays.toString(isVisited));
        }

        for (int i = 1; i <= largest; i++) {
            if (!isVisited[i]) {
                return false;
            }
        }

        return true;
    }
}
