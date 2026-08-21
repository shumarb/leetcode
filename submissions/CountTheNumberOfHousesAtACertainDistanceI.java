// Question: https://leetcode.com/problems/count-the-number-of-houses-at-a-certain-distance-i/description/

class CountTheNumberOfHousesAtACertainDistanceI {
    private List<Integer>[] graph;
    private int[] result;
    private int n;

    public int[] countOfPairs(int n, int x, int y) {
        boolean isTest = false;
        graph = new ArrayList[n + 1];
        result = new int[n];
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

        for (int i = 1; i <= n; i++) {
            bfs(i);
        }
        if (isTest) {
            System.out.println("---------------------------\nresult: " + Arrays.toString(result));
        }

        return result;
    }

    private void bfs(int source) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n + 1];
        int level = 1;

        isVisited[source] = true;
        for (int next: graph[source]) {
            if (!isVisited[next]) {
                isVisited[next] = true;
                queue.offer(next);
            }
        }
        result[level - 1] += queue.size();

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int house = queue.poll();
                for (int next: graph[house]) {
                    if (!isVisited[next]) {
                        isVisited[next] = true;
                        queue.offer(next);
                    }
                }
            }

            result[++level - 1] += queue.size();
        }
    }
}
