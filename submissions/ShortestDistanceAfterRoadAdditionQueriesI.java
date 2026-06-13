// Question: https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/description/

class ShortestDistanceAfterRoadAdditionQueriesI {
    private int n;

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer>[] graph = new ArrayList[n];
        boolean isTest = false;
        int j = 0;
        int size = queries.length;
        int[] result = new int[size];
        this.n = n;

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            graph[i].add(i + 1);
        }
        for (int[] query: queries) {
            int first = query[0];
            int second = query[1];

            graph[first].add(second);
            if (isTest) {
                print(first + " -> " + second + "\ngraph:", graph);
            }

            result[j++] = compute(graph);
        }
        if (isTest) {
            System.out.println("---------------------------------------\nresult: " + Arrays.toString(result));
        }

        return result;
    }

    private int compute(List<Integer>[] graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n];
        int result = 0;

        queue.offer(0);
        isVisited[0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int top = queue.poll();
                if (top == graph.length - 1) {
                    return result;
                }

                for (int next: graph[top]) {
                    if (!isVisited[next]) {
                        queue.offer(next);
                        isVisited[next] = true;
                    }
                }
            }

            result++;
        }

        return -1;
    }

    private void print(String s, List<Integer>[] graph) {
        System.out.println("---------------------------------------\n" + s);
        for (int i = 0; i < graph.length; i++) {
            System.out.println(" * " + i + ": " + graph[i]);
        }
    }
}
