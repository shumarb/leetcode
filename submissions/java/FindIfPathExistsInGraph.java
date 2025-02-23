// Question: https://leetcode.com/problems/find-if-path-exists-in-graph/description/

class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = new List[n];
        boolean[] visited = new boolean[n];

        // 1. Populate graph.
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge: edges) {
            int start = edge[0];
            int end = edge[1];
            graph[start].add(end);
            graph[end].add(start);
        }

        // 2. Execute breadth-first search on start vertex.
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 3. Path exists.
            if (current == destination) {
                return true;
            }

            // 4. Skip current node if it has been visited.
            if (visited[current]) {
                continue;
            }

            /** 5.  Mark current node as visited
             and check its unvisited neighbours.
             */
            visited[current] = true;
            for (int neighbour: graph[current]) {
                if (!visited[neighbour]) {
                    queue.offer(neighbour);
                }
            }
        }

        // 6. No path exists.
        return false;
    }
}