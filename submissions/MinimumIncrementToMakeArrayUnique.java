// Question: https://leetcode.com/problems/minimum-increment-to-make-array-unique/description/

class MinimumIncrementToMakeArrayUnique {
    public int minIncrementForUnique(int[] nums) {
        boolean isTest = false;
        int minIncrementForUnique = 0;

        nums = sort(nums);
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums));
        }
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int previous = nums[i - 1];
            if (current <= previous) {
                int difference = previous - current + 1;
                nums[i] += difference;
                minIncrementForUnique += difference;
            }
        }
        if (isTest) {
            System.out.println("updated nums: " + Arrays.toString(nums) + "\nminIncrementForUnique: " + minIncrementForUnique);
        }

        return minIncrementForUnique;
    }

    private int[] sort(int[] arr) {
        int j = 0;
        int largest = arr[0];

        for (int number: arr) {
            largest = Math.max(largest, number);
        }
        int[] frequency = new int[largest + 1];
        for (int number: arr) {
            frequency[number]++;
        }
        for (int i = 0; i <= largest; i++) {
            while (frequency[i]-- > 0) {
                arr[j++] = i;
            }
        }
        return arr;
    }
}