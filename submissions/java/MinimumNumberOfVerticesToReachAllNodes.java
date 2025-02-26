// Question: https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/description/

class MinimumNumberOfVerticesToReachAllNodes {
    private boolean isTest = false;

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> result = new ArrayList<>();
        boolean[] destinations = getDestinations(n, edges);

        if (isTest) {
            display(n, edges);
            System.out.println("destinations: " + Arrays.toString(destinations));
        }

        for (int i = 0; i < n; i++) {
            /**
             1.  Only count vertices with 0 incoming edges
             because there exists a path for all other vertices with at leat 1 incoming edge,
             and these vertices with 0 incoming edges must be counted in order to reach all nodes.
             */
            if (!destinations[i]) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean[] getDestinations(int n, List<List<Integer>> edges) {
        boolean[] result = new boolean[n];
        for (List<Integer> edge: edges) {
            result[edge.get(1)] = true;
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