// Question: https://leetcode.com/problems/semi-ordered-permutation/description/

class SemiOrderedPermutation class Solution {
    private int[] nums;

    public int semiOrderedPermutation(int[] nums) {
        boolean isTest = false;
        int count = 0;
        int index = 0;
        int n = nums.length;
        this.nums = nums;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                index = i;
                break;
            }
        }
        while (nums[0] != 1) {
            swap(index, index - 1);
            count++;
            index--;
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
            swap(index, index + 1);
            count++;
            index++;
        }
        if (isTest) {
            System.out.println("solved last:  " + Arrays.toString(nums) + " -> count: " + count);
        }

        return count;
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}