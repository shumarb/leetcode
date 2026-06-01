// Question: https://leetcode.com/problems/jump-game-ii/description/

class JumpGameII {
    public int jump(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        int n = nums.length;
        int result = 0;
        boolean isTest = false;
        boolean[] isVisited = new boolean[n];

        if (n == 1) {
            return 0;
        }

        isVisited[0] = true;
        queue.offer(0);

        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("------------------\nlevel: " + result + ": " + queue);
            }

            int size = queue.size();
            while (size-- > 0) {
                int index = queue.poll();

                if (index == n - 1) {
                    if (isTest) {
                        System.out.println(" * result @ level " + result);
                    }

                    return result;
                }

                int maximumJumps = nums[index];
                while (maximumJumps > 0) {
                    int nextIndex = index + maximumJumps--;
                    if (nextIndex == n - 1) {
                        result++;
                        if (isTest) {
                            System.out.println(" * result @ level " + result);
                        }

                        return result;
                    }

                    if (nextIndex < n && !isVisited[nextIndex]) {
                        queue.offer(nextIndex);
                        isVisited[nextIndex] = true;
                    }
                }
            }

            result++;
        }

        return result;
    }
}
