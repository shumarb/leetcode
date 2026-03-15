// Question: https://leetcode.com/problems/time-needed-to-inform-all-employees/description/

class TimeNeededToInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n];
        boolean isTest = false;
        int result = 0;

        graph.put(headID, new ArrayList<>());
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                graph.putIfAbsent(i, new ArrayList<>());
                graph.putIfAbsent(manager[i], new ArrayList<>());
                graph.get(manager[i]).add(i);
            }
        }
        if (isTest) {
            System.out.println("graph:");
            for (Map.Entry<Integer, List<Integer>> e: graph.entrySet()) {
                System.out.println(" * " + e.getKey() + " -> " + e.getValue());
            }
            System.out.println("--------------------------------------------");
        }

        queue.offer(new int[] {headID, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int time = current[1];

            isVisited[node] = true;
            result = Math.max(result, time);
            for (int neighbour: graph.get(node)) {
                if (!isVisited[neighbour]) {
                    queue.offer(new int[] {neighbour, time + informTime[node]});
                }
            }
        }
        if (isTest) {
            System.out.println("--------------------------------------------\nresult: " + result);
        }

        return result;
    }
}