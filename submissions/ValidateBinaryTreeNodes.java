// Question: https://leetcode.com/problems/validate-binary-tree-nodes/description/

class ValidateBinaryTreeNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n];
        boolean isTest = false;
        int[] inDegree = new int[n];
        int level = -1;
        int root = -1;
        int totalVisitedNodes = 0;

        // 1. Update a node's in-degree. If its value exceeds 1, a cycle is detected.
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                int child = leftChild[i];
                int parent = i;
                graph.putIfAbsent(child, new ArrayList<>());
                graph.putIfAbsent(parent, new ArrayList<>());
                graph.get(parent).add(child);
                if (++inDegree[child] > 1) {
                    return false;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (rightChild[i] != -1) {
                int child = rightChild[i];
                int parent = i;
                graph.putIfAbsent(child, new ArrayList<>());
                graph.putIfAbsent(parent, new ArrayList<>());
                graph.get(parent).add(child);
                if (++inDegree[child] > 1) {
                    return false;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                // 2. More than 1 root detected, hence invalid binary tree.
                if (root != -1) {
                    return false;
                }
                root = i;
            }
        }
        // 3. No root, hence invalid binary tree.
        if (root == -1) {
            return false;
        }

        // 4. Important step because root (if available) was no added in first 2 for loops.
        graph.putIfAbsent(root, new ArrayList<>());
        if (isTest) {
            System.out.println("inDegree: " + Arrays.toString(inDegree) + "\nroot: " + root);
            System.out.println("--------------------------------------------\ngraph:");
            for (Map.Entry<Integer, List<Integer>> e: graph.entrySet()) {
                System.out.println(" * " + e.getKey() + " -> " + e.getValue());
            }
            System.out.println("--------------------------------------------");
        }

        // 4. Execute BFS on root.
        // If a node encountered has been visited, cycle detected.
        // After BFS, if not all nodes visited, invalid binary tree.
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++level;
            if (isTest) {
                System.out.println("level: " + level + " -> queue: " + queue);
            }

            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (isVisited[current]) {
                    return false;
                }

                ++totalVisitedNodes;
                isVisited[current] = true;
                for (int neighbour: graph.get(current)) {
                    if (isVisited[neighbour]) {
                        return false;
                    }
                    queue.offer(neighbour);
                }
            }
        }
        if (isTest) {
            System.out.println("--------------------------------------------");
            System.out.println("isVisited: " + Arrays.toString(isVisited) + "\ntotalVisitedNodes: " + totalVisitedNodes);
        }

        return totalVisitedNodes == n;
    }
}