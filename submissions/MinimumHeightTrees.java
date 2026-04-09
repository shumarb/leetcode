// Question:

class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 1. Edge case: Tree has 1 node, so distance from root to leaf is 0.
        if (n == 1) {
            List<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }

        List<Integer>[] graph = new ArrayList[n];
        Queue<Integer> queue = new LinkedList<>();
        boolean isTest = false;
        int[] inDegree = new int[n];
        int remainingNodes = n;

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge: edges) {
            int first = edge[0];
            int second = edge[1];

            graph[first].add(second);
            graph[second].add(first);
            inDegree[first]++;
            inDegree[second]++;
        }
        if (isTest) {
            System.out.println("inDegree: " + Arrays.toString(inDegree));
            System.out.println("------------------------------\ngraph:");
            for (int i = 0; i < graph.length; i++) {
                System.out.println(" * " + i + ": " + graph[i]);
            }
        }

        /**
         1.  Shrink the graph by removing its leaves level by level
         until there are <= 2 nodes to check. These nodes form the centroid of the tree,
         which spans the minimum height of the tree.
         */
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 1) {
                queue.offer(i);
            }
        }
        while (remainingNodes > 2) {
            int size = queue.size();
            remainingNodes -= size;

            if (isTest) {
                System.out.println("------------------------------\nqueue: " + queue);
            }
            for (int i = 0; i < size; i++) {
                int source = queue.poll();
                for (int destination: graph[source]) {
                    if (--inDegree[destination] == 1) {
                        queue.offer(destination);
                    }
                }
            }
        }
        if (isTest) {
            System.out.println("------------------------------\nresult: " + queue);
        }

        return new ArrayList<>(queue);
    }
}
