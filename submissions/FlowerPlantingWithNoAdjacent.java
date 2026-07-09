// Question: https://leetcode.com/problems/flower-planting-with-no-adjacent/description/

class FlowerPlantingWithNoAdjacent {
    private List<Integer>[] graph;
    private int[] colour;
    private int n;

    public int[] gardenNoAdj(int n, int[][] paths) {
        if (n == 1) {
            return new int[] {1};
        }

        boolean[] isVisited = new boolean[n + 1];
        boolean isTest = false;
        int[] result = new int[n];
        colour = new int[n + 1];
        graph = new ArrayList[n + 1];
        this.n = n;

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] path: paths) {
            int first = path[0];
            int second = path[1];
            graph[first].add(second);
            graph[second].add(first);
        }
        if (isTest) {
            print("before\n");
        }
        for (int i = 1; i <= n; i++) {
            if (!isVisited[i]) {
                dfs(i, isVisited);
            }
        }
        for (int i = 1; i <= n; i++) {
            result[i - 1] = colour[i];
        }
        if (isTest) {
            print("after\n");
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }

    private void dfs(int node, boolean[] isVisited) {
        boolean[] isColourUsed = new boolean[5];
        isVisited[node] = true;

        for (int neighbour: graph[node]) {
            int neighbourColour = colour[neighbour];
            if (neighbourColour != 0) {
                isColourUsed[neighbourColour] = true;
            }
        }

        for (int i = 1; i <= isColourUsed.length; i++) {
            if (!isColourUsed[i]) {
                colour[node] = i;
                break;
            }
        }

        for (int neighbour: graph[node]) {
            if (!isVisited[neighbour]) {
                dfs(neighbour, isVisited);
            }
        }
    }

    private void print(String s) {
        System.out.println(s + "\ncolour: " + Arrays.toString(colour) + "\ngraph:");
        for (int i = 1; i <= n; i++) {
            System.out.println(" * " + i + ": " + graph[i]);
        }
        System.out.println("-----------------------------");
    }
}
