// Question: https://leetcode.com/problems/removing-minimum-and-maximum-from-array/description/

class RemovingMinimumAndMaximumFromArray {
    public int minimumDeletions(int[] nums) {
        boolean isTest = false;
        int leftMostIndex = -1;
        int maximum = Integer.MIN_VALUE;
        int maximumIndex = -1;
        int minimum = Integer.MAX_VALUE;
        int minimumIndex = -1;
        int n = nums.length;
        int option1 = 0;
        int option2 = 0;
        int option3 = 0;
        int rightMostIndex = -1;

        for (int i = 0; i < n; i++) {
            int element = nums[i];
            if (element > maximum) {
                maximum = element;
                maximumIndex = i;
            }

            if (element < minimum) {
                minimum = element;
                minimumIndex = i;
            }
        }

        leftMostIndex = Math.min(maximumIndex, minimumIndex);
        rightMostIndex = Math.max(maximumIndex, minimumIndex);

        // 1. Delete both maximum and minimum from left.
        option1 = 1 + rightMostIndex;

        // 2. Delete both maximum and minimum from right.
        option2 = n - leftMostIndex;

        // 3. Delete leftMostIndex from left, and rightMostIndex from right.
        option3 = 1 + leftMostIndex + n - rightMostIndex;
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\n * minimum: " + minimum + "\n * minimumIndex: " + minimumIndex + "\n * maximumIndex: " + maximumIndex + "\n * leftMostIndex: " + leftMostIndex + "\n * rightMostIndex: " + rightMostIndex + "\n * option1: " + option1 + "\n * option2: " + option2 + "\n * option3: " + option3);
        }

        return Math.min(option1, Math.min(option2, option3));
    }
}
