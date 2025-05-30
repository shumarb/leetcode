// Question: https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/description/

class MinimumNumberOfVerticesToReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> result = new ArrayList<>();
        boolean[] hasIncomingEdge = new boolean[n];
        boolean isTest = false;

        /**
         1.  Mark vertices with >= 1 incoming edge.
         This means that there exists a path to these vertices.
         */
        for (List<Integer> edge: edges) {
            hasIncomingEdge[edge.get(1)] = true;
        }
        if (isTest) {
            display(n, edges);
            System.out.println("hasIncomingEdge: " + Arrays.toString(hasIncomingEdge));
        }

        for (int i = 0; i < n; i++) {
            /**
             2.  Only count vertices with 0 incoming edges
             because these vertices must be counted in order to reach all nodes.
             */
            if (!hasIncomingEdge[i]) {
                result.add(i);
            }
        }

        return result;
    }

    private void display(int n, List<List<Integer>> edges) {
        System.out.println("-----------------------------------------------");
        System.out.println("n: " + n);
        System.out.println();
        System.out.println("edges:");
        for (List<Integer> edge: edges) {
            System.out.println(edge.get(0) + " ------> " + edge.get(1));
        }
        System.out.println("-----------------------------------------------");
    }
}