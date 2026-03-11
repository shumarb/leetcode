// Question: https://leetcode.com/problems/validate-binary-tree-nodes/description/

class ValidateBinaryTreeNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n];
        boolean isTest = false;
        int[] parentCount = new int[n];
        int countNodesWithNoParent = 0;
        int root = -1;

        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                parentCount[leftChild[i]]++;
            }
            if (rightChild[i] != -1) {
                parentCount[rightChild[i]]++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (parentCount[i] == 0) {
                countNodesWithNoParent++;
                root = i;
            }
        }
        if (isTest) {
            System.out.println("parentCount: " + Arrays.toString(parentCount) + "\nroot: " + root + "\ncountNodesWithNoParent: " + countNodesWithNoParent);
            System.out.println("-----------------------------------------------------------------");
        }

        // 1. Edge case: no root or > 1 possible root.
        if (root == -1 || countNodesWithNoParent != 1) {
            return false;
        }

        graph.putIfAbsent(root, new ArrayList<>());
        populate(graph, leftChild);
        populate(graph, rightChild);
        if (isTest) {
            System.out.println("graph:");
            for (Map.Entry<Integer, List<Integer>> e: graph.entrySet()) {
                System.out.println(" * " + e.getKey() + " -> " + e.getValue());
            }
        }


        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (isTest) {
                System.out.println("level: " + level + " -> queue: " + queue);
            }

            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (isVisited[current]) {
                    return false;
                }

                isVisited[current] = true;
                for (int neighbour: graph.get(current)) {
                    if (isVisited[neighbour]) {
                        return false;
                    }
                    queue.offer(neighbour);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                return false;
            }
        }

        return true;
    }

    private void populate(Map<Integer, List<Integer>> graph, int[] child) {
        for (int i = 0; i < child.length; i++) {
            if (child[i] != -1) {
                graph.putIfAbsent(i, new ArrayList<>());
                graph.putIfAbsent(child[i], new ArrayList<>());
                graph.get(i).add(child[i]);
            }
        }
    }
}