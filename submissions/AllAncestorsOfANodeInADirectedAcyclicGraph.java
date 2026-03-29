// Question: https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/description/

class AllAncestorsOfANodeInADirectedAcyclicGraph class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] isAncestor = new boolean[n][n];
        boolean isTest = false;

        for (int[] edge: edges) {
            isAncestor[edge[1]][edge[0]] = true;
        }
        if (isTest) {
            System.out.println("isAncestor:");
            for (int i = 0; i < isAncestor.length; i++) {
                System.out.println(" * " + i + ": " + Arrays.toString(isAncestor[i]));
            }
        }

        for (int source = 0; source < isAncestor.length; source++) {
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < isAncestor.length; j++) {
                if (isAncestor[source][j]) {
                    queue.offer(j);
                }
            }

            if (queue.isEmpty()) {
                result.add(new ArrayList<>());
            } else {
                List<Integer> ancestors = getAncestors(isAncestor, queue);
                result.add(ancestors);
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------------\nresult:");
            for (int i = 0; i < result.size(); i++) {
                System.out.println(" * " + i + ": " + result.get(i));
            }
        }

        return result;
    }

    private List<Integer> getAncestors(boolean[][] isAncestor, Queue<Integer> queue) {
        List<Integer> result = new ArrayList<>();
        boolean[] isVisited = new boolean[isAncestor.length];

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                isVisited[current] = true;

                for (int j = 0; j < isAncestor.length; j++) {
                    if (isAncestor[current][j] && !isVisited[j]) {
                        queue.offer(j);
                    }
                }
            }
        }
        for (int i = 0; i < isVisited.length; i++) {
            if (isVisited[i]) {
                result.add(i);
            }
        }

        return result;
    }
}
