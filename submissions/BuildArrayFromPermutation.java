// Question: https://leetcode.com/problems/build-array-from-permutation/description/

class BuildArrayFromPermutation {
    public int[] buildArray(int[] nums) {
        boolean isTest = false;
        int len = nums.length;
        int[] result = new int[len];

        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[nums[i]];
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}