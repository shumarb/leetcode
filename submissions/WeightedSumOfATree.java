// Question: https://leetcode.com/problems/weighted-sum-of-a-tree/description/

class WeightedSumOfATree {
    public long weightedSum(int[] parent, int[] nums) {
        List<Integer>[] graph = new ArrayList[parent.length];
        Queue<Integer> queue = new LinkedList<>();
        boolean isTest = false;
        int depth = 1;
        int height;
        int n = parent.length;
        long result = 0;

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int p = parent[i];
            if (p >= 0) {
                graph[p].add(i);
            }
        }
        height = getHeight(graph);
        if (isTest) {
            System.out.println("height: " + height + "\ngraph:");
            for (int i = 0; i < n; i++) {
                System.out.println(" * " + i + ": " + graph[i]);
            }
            System.out.println("-----------------------------");
        }

        queue.offer(0);
        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println(" * depth " + depth + ": " + queue);
            }

            int size = queue.size();
            while (size-- > 0) {
                int source = queue.poll();
                result += ((long) nums[source]) * (long) (height - depth + 1);
                for (int next: graph[source]) {
                    queue.offer(next);
                }
            }
            depth++;
        }
        if (isTest) {
            System.out.println("-----------------------------\nresult: " + result);
        }

        return result;
    }

    private int getHeight(List<Integer>[] graph) {
        Queue<Integer> queue = new LinkedList<>();
        int result = 1;

        queue.offer(0);
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int source = queue.poll();
                for (int next: graph[source]) {
                    queue.offer(next);
                }
            }
            if (queue.isEmpty()) {
                break;
            }

            result++;
        }

        return result;
    }
}
