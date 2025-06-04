// Question: https://leetcode.com/problems/number-of-provinces/description/

class NumberOfProvinces {
    private int n;
    private boolean[] isVisited;

    public int findCircleNum(int[][] isConnected) {
        int countProvinces = 0;
        n = isConnected.length;
        isVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                // 1. Execute depth-first search on visited vertex.
                dfs(i, isConnected);

                /**
                 2.  A province is found by doing a depth-first search on current unvisited vertex
                     and marking all vertices encountered during this search as visited.
                 */
                countProvinces++;
            }
        }

        return countProvinces;
    }

    private void dfs(int vertex, int[][] isConnected) {
        // 3. Mark vertex as visited and add it to stack.
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex);
        isVisited[vertex] = true;

        while (!stack.isEmpty()) {
            // 4. Retrieve last-visited element.
            int current = stack.pop();

            /**
             5.  Perform depth-first search
                 on an unvisited adjacent neighbour of last-visited element.
             */
            for (int i = 0; i < n; i++) {
                if (isConnected[vertex][i] == 1 && !isVisited[i]) {
                    dfs(i, isConnected);
                }
            }
        }
    }
}