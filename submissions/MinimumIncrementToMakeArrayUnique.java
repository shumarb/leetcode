// Question: https://leetcode.com/problems/minimum-increment-to-make-array-unique/description/

class MinimumIncrementToMakeArrayUnique {
    public int minIncrementForUnique(int[] nums) {
        boolean isTest = false;
        int minIncrementForUnique = 0;

        Arrays.sort(nums);
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums));
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int current = nums[i];
            int next = nums[i + 1];
            if (isTest) {
                System.out.println("compare: | current: " + current + ", next: " + next);
            }
            if (current >= next) {
                int difference = current + 1 - next;
                nums[i + 1] += difference;
                minIncrementForUnique += difference;
            }
        }
        if (isTest) {
            System.out.println("updated nums: " + Arrays.toString(nums));
        }

        return minIncrementForUnique;
    }
}