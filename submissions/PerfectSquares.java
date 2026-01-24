// Question: https://leetcode.com/problems/perfect-squares/description/

class PerfectSquares {
    public int numSquares(int n) {
        List<Integer> perfectSquares = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isChecked = new boolean[n + 1];
        boolean isTest = false;
        int i = 1;
        int level = 0;

        while (i * i <= n) {
            perfectSquares.add(i * i);
            i++;
        }
        if (isTest) {
            System.out.println("perfect squares: " + perfectSquares);
        }

        queue.offer(0);
        isChecked[0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();

            if (isTest) {
                System.out.println("level: " + level + " -> queue: " + queue);
            }
            for (int j = 0; j < size; j++) {
                int top = queue.poll();
                for (int perfect: perfectSquares) {
                    int sum = top + perfect;
                    if (sum == n) {
                        if (isTest) {
                            System.out.println(" * found " + n + " @ next level --> return next level: " + (level + 1));
                        }
                        return level + 1;

                    } else if (sum < n && !isChecked[sum]) {
                        isChecked[sum] = true;
                        queue.offer(sum);
                    }
                }
            }

            level++;
        }

        return 0;
    }
}