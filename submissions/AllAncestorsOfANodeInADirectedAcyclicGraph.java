// Question: https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/description/

class AllAncestorsOfANodeInADirectedAcyclicGraph {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[n];
        Set<Integer>[] ancestors = new HashSet[n];
        boolean isTest = false;
        int[] inDegree = new int[n];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
            ancestors[i] = new HashSet<>();
        }
        for (int[] edge: edges) {
            int destination = edge[1];
            int source = edge[0];
            graph[source].add(destination);
            inDegree[destination]++;
        }
        if (isTest) {
            System.out.println("inDegree: " + Arrays.toString(inDegree) + "\n-------------------------------------\ngraph:");
            for (int i = 0; i < graph.length; i++) {
                System.out.println(" * " + i + ": " + graph[i]);
            }
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbour: graph[current]) {
                ancestors[neighbour].add(current);
                ancestors[neighbour].addAll(ancestors[current]);
                if (--inDegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }
        if (isTest) {
            System.out.println("-------------------------------------\nancestors:");
            for (int i = 0; i < ancestors.length; i++) {
                System.out.println(" * " + i + ": " + ancestors[i]);
            }
        }

        for (int i = 0; i < ancestors.length; i++) {
            if (ancestors[i].isEmpty()) {
                result.add(new ArrayList<>());
            } else {
                result.add(getSortedAncestors(ancestors[i], ancestors.length));
            }
        }
        if (isTest) {
            System.out.println("-------------------------------------\nresult:");
            for (int i = 0; i < result.size(); i++) {
                System.out.println(" * " + i + ": " + result.get(i));
            }
        }

        return result;
    }

    private List<Integer> getSortedAncestors(Set<Integer> ancestors, int n) {
        List<Integer> result = new ArrayList<>();
        boolean[] isPresent = new boolean[n];

        for (int ancestor: ancestors) {
            isPresent[ancestor] = true;
        }
        for (int i = 0; i < n; i++) {
            if (isPresent[i]) {
                result.add(i);
            }
        }

        return result;
    }
}