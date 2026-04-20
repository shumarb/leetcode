// Question: https://leetcode.com/problems/count-the-number-of-complete-components/description/

class CountTheNumberOfCompleteComponents {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        boolean[] isVisited = new boolean[n];
        boolean isTest = false;
        int result = 0;

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        if (isTest) {
            System.out.println("graph:");
            for (int i = 0; i < graph.length; i++) {
                System.out.println(" * " + i + ": " + graph[i]);
            }
            System.out.println("-----------------------------");
        }

        for (int i = 0; i < isVisited.length; i++) {
            if (isVisited[i]) {
                continue;
            }

            List<Integer> component = new ArrayList<>();
            dfs(i, isVisited, graph, component);
            if (isTest) {
                System.out.print(" * component: " + component);
            }

            boolean isCompleteComponent = true;
            for (int part: component) {
                if (graph[part].size() != component.size() - 1) {
                    isCompleteComponent = false;
                    break;
                }
            }
            if (isCompleteComponent) {
                if (isTest) {
                    System.out.print(" | valid");
                }
                result++;
            }
            if (isTest) {
                System.out.println();
            }
        }
        if (isTest) {
            System.out.println("-----------------------------\nresult: " + result);
        }

        return result;
    }

    private void dfs(int source, boolean[] isVisited, List<Integer>[] graph, List<Integer> component) {
        component.add(source);
        isVisited[source] = true;

        for (int destination: graph[source]) {
            if (!isVisited[destination]) {
                dfs(destination, isVisited, graph, component);
            }
        }
    }
}
