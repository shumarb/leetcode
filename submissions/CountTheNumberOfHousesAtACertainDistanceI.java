// Question: https://leetcode.com/problems/count-the-number-of-houses-at-a-certain-distance-i/description/

class CountTheNumberOfHousesAtACertainDistanceI {
    private List<Integer>[] graph;
    private int[] result;
    private int n;

    public int[] countOfPairs(int n, int x, int y) {
        boolean isTest = false;
        result = new int[n];
        graph = new ArrayList[n + 1];
        this.n = n;

        if (isTest) {
            System.out.println("n: " + n + ", x: " + x + ", y: " + y + "\n---------------------------");
        }
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[x].add(y);
        graph[y].add(x);
        for (int i = 1; i < n; i++) {
            graph[i].add(i + 1);
            graph[i + 1].add(i);
        }
        if (isTest) {
            System.out.println("graph:");
            for (int i = 1; i <= n; i++) {
                System.out.println(" * " + i + ": " + graph[i]);
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                bfs(i, k);
            }
        }
        if (isTest) {
            System.out.println("---------------------------\nresult: " + Arrays.toString(result));
        }

        return result;
    }

    private void bfs(int node, int k) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n + 1];
        int depth = 0;

        queue.offer(node);
        isVisited[node] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();

            if (depth++ == k) {
                result[k - 1] += queue.size();
                break;
            }

            while (size-- > 0) {
                int top = queue.poll();

                for (int next: graph[top]) {
                    if (!isVisited[next]) {
                        queue.offer(next);
                        isVisited[next] = true;
                    }
                }
            }
        }
    }
}
