// Question: https://leetcode.com/problems/minimum-number-of-operations-to-have-distinct-elements/description/

class MinimumNumberOfOperationsToHaveDistinctElements {
    public int minOperations(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isPresent;
        boolean isTest = false;
        int[] count;
        int countDistinct = 0;
        int largest = 0;
        int n = nums.length;
        int result = 0;

        for (int e: nums) {
            largest = Math.max(e, largest);
            queue.offer(e);
        }
        isPresent = new boolean[largest + 1];
        count = new int[largest + 1];
        for (int e: nums) {
            if (!isPresent[e]) {
                isPresent[e] = true;
                countDistinct++;
            }
            count[e]++;
        }
        if (isTest) {
            System.out.println("countDistinct: " + countDistinct);
        }

        if (countDistinct == n) {
            return result;
        }

        while (queue.size() >= 3) {
            if (isTest) {
                System.out.println("----------------------------------");
                System.out.println("before, queue: " + queue + "\n * countDistinct: " + countDistinct + "\n * result: " + result);
            }
            for (int i = 0; i < 3; i++) {
                int top = queue.poll();
                count[top]--;
                if (count[top] == 0) {
                    countDistinct--;
                }
            }
            result++;
            if (isTest) {
                System.out.println("\nafter, queue: " + queue + "\n * countDistinct: " + countDistinct + "\n * result: " + result);
            }

            if (countDistinct == queue.size()) {
                if (isTest) {
                    System.out.println(" ** queue has distinct remaining elements, return result: " + result);
                }
                return result;
            }
        }
        if (isTest) {
            System.out.println("----------------------------------");
            System.out.println("remaining queue after while: " + queue + "\n * countDistinct: " + countDistinct + "\n * result: " + result);
        }

        return countDistinct == n ? result : result + 1;
    }
}