// Question: https://leetcode.com/problems/validate-binary-tree-nodes/description/

class ValidateBinaryTreeNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
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
                if (++inDegree[leftChild[i]] > 1) {
                    return false;
                }
            }
            if (rightChild[i] != -1) {
                if (++inDegree[rightChild[i]] > 1) {
                    return false;
                }
            }
        }

        /**
         2. Find root. Return false if no root or more than 1 root exists.
         */
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                if (root != -1) {
                    return false;
                }
                root = i;
            }
        }
        if (root == -1) {
            return false;
        }

        if (isTest) {
            System.out.println("inDegree: " + Arrays.toString(inDegree) + "\nroot: " + root);
            System.out.println("--------------------------------------------");
        }

        /**
         3.  Execute BFS on root.
         If a node encountered has been visited, cycle detected.
         After BFS executed, valid binary tree is found only if all nodes are visited exactly once.
         */
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
                int child;
                if (leftChild[current] != -1) {
                    child = leftChild[current];
                    if (isVisited[child]) {
                        return false;
                    }
                    queue.offer(child);
                }
                if (rightChild[current] != -1) {
                    child = rightChild[current];
                    if (isVisited[child]) {
                        return false;
                    }
                    queue.offer(child);
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