// Question: https://leetcode.com/problems/count-the-number-of-complete-components/description/

class CountTheNumberOfCompleteComponents {
    private boolean isTest;

    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        boolean[] isVisited = new boolean[n];
        int result = 0;
        isTest = false;

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
                System.out.println(" * component: " + component);
            }
            if (component.size() == 1 || isValid(component, graph)) {
                if (isTest) {
                    System.out.println(" * valid\n");
                }
                result++;
            }
        }
        if (isTest) {
            System.out.println("-----------------------------\nresult: " + result);
        }

        return result;
    }

    private boolean isValid(List<Integer> component, List<Integer>[] graph) {
        for (int vertex: component) {
            List<Integer> destinations = graph[vertex];
            int totalConnections = getTotalConnections(component, destinations);
            if (isTest) {
                System.out.println(" ** vertex: " + vertex + " | destinations: " + destinations + " | totalConnections: " + totalConnections);
            }
            if (totalConnections != component.size() - 1) {
                return false;
            }
        }

        return true;
    }

    private int getTotalConnections(List<Integer> component, List<Integer> destinations) {
        int result = 0;

        for (int part: component) {
            for (int destination: destinations) {
                if (destination == part) {
                    result++;
                    break;
                }
            }
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
