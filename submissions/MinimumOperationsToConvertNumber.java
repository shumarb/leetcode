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

                if (top == goal) {
                    if (isTest) {
                        System.out.println(" ** found @ level " + level);
                    }

                    return level;
                }

                for (int number: nums) {
                    int x = top + number;
                    if (x == goal) {
                        level++;

                        if (isTest) {
                            System.out.println(" ** found @ level " + level);
                        }

                        return level;
                    }

                    if (x >= 0 && x <= 1000 && !isVisited[x]) {
                        queue.offer(x);
                        isVisited[x] = true;
                    }

                    x = top - number;
                    if (x == goal) {
                        level++;

                        if (isTest) {
                            System.out.println(" ** found @ level " + level);
                        }

                        return level;
                    }

                    if (x >= 0 && x <= 1000 && !isVisited[x]) {
                        queue.offer(x);
                        isVisited[x] = true;
                    }

                    x = top ^ number;
                    if (x == goal) {
                        level++;

                        if (isTest) {
                            System.out.println(" ** found @ level " + level);
                        }

                        return level;
                    }

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
