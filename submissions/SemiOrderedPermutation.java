// Question: https://leetcode.com/problems/semi-ordered-permutation/description/

class SemiOrderedPermutation {
    public int semiOrderedPermutation(int[] nums) {
        boolean isTest = false;
        int count = 0;
        int index = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                index = i;
                break;
            }
        }
        while (nums[0] != 1) {
            int temp = nums[index];
            nums[index] = nums[index - 1];
            nums[index-- - 1] = temp;
            count++;
        }
        if (isTest) {
            System.out.println("solved first: " + Arrays.toString(nums) + " -> count: " + count);
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == n) {
                index = i;
                break;
            }
        }
        while (nums[n - 1] != n) {
            int temp = nums[index];
            nums[index] = nums[index + 1];
            nums[index + 1] = temp;
            count++;
            index++;
        }
        if (isTest) {
            System.out.println("solved last:  " + Arrays.toString(nums) + " -> count: " + count);
        }

        return count;
    }
}