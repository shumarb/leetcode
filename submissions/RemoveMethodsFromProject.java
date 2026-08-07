// Question: https://leetcode.com/problems/remove-methods-from-project/description/

class RemoveMethodsFromProject {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer> result = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[n];
        boolean[] isSuspicious = new boolean[n];
        boolean isTest = false;

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e: invocations) {
            graph[e[0]].add(e[1]);
        }

        dfs(k, graph, isSuspicious);
        for (int[] e: invocations) {
            int destination = e[1];
            int source = e[0];

            if (!isSuspicious[source] && isSuspicious[destination]) {
                result.clear();
                for (int i = 0; i < n; i++) {
                    result.add(i);
                }

                return result;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!isSuspicious[i]) {
                result.add(i);
            }
        }
        if (isTest) {
            System.out.println("k: " + k + "\n\ngraph:");
            for (int i = 0; i < n; i++) {
                System.out.println(" * " + i + ": " + graph[i]);
            }
            System.out.println("\nisSuspicious: " + Arrays.toString(isSuspicious) + "\n\nresult: " + result);
        }

        return result;
    }

    private void dfs(int node, List<Integer>[] graph, boolean[] isSuspicious) {
        isSuspicious[node] = true;

        for (int next: graph[node]) {
            if (!isSuspicious[next]) {
                dfs(next, graph, isSuspicious);
            }
        }
    }
}
