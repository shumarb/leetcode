// Question: https://leetcode.com/problems/minimum-operations-to-convert-number/description/

class MinimumOperationsToConvertNumber {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[1001];
        boolean isTest = false;
        int level = 0;

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\n" + start + " -> " + goal);
        }

        queue.offer(start);
        isVisited[start] = true;

        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("----------------------------------\nlevel " + level + ": " + queue);
            }

            int size = queue.size();
            while (size-- > 0) {
                int top = queue.poll();

                for (int number: nums) {
                    if (top + number == goal || top - number == goal || (top ^ number) == goal) {
                        level++;

                        if (isTest) {
                            System.out.println(" ** found @ level " + level);
                        }

                        return level;
                    }

                    int x = top + number;
                    if (x >= 0 && x <= 1000 && !isVisited[x]) {
                        queue.offer(x);
                        isVisited[x] = true;
                    }

                    x = top - number;
                    if (x >= 0 && x <= 1000 && !isVisited[x]) {
                        queue.offer(x);
                        isVisited[x] = true;
                    }

                    x = top ^ number;
                    if (x >= 0 && x <= 1000 && !isVisited[x]) {
                        queue.offer(x);
                        isVisited[x] = true;
                    }
                }
            }

            level++;
        }

        return -1;
    }
}
