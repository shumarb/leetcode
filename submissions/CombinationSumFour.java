// Question: https://leetcode.com/problems/combination-sum-iv/description/

class CombinationSumFour {
    public int combinationSum4(int[] nums, int target) {
        // 1. Edge case: single element.
        if (nums.length == 1) {
            return nums[0] == target ? 1 : 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean isTest = true;
        int level = 0;
        int total = 0;

        queue.offer(0);
        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("----------------------------------\nlevel: " + level + " -> queue: " + queue);
            }
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (int e: nums) {
                    int next = current + e;
                    if (isTest) {
                        System.out.println(" * current: " + current + ", e: " + e + " -> next: " + next);
                    }
                    if (next == target) {
                        if (isTest) {
                            System.out.println(" ** found");
                        }
                        total++;

                    } else if (next < target) {
                        queue.offer(next);
                    }
                }
            }
        }
        if (isTest) {
            System.out.println("----------------------------------\ntotal: " + total);
        }

        return total;
    }
}