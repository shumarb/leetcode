// Question: https://leetcode.com/problems/sort-array-by-parity/description/

class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }
            while (left < right && nums[right] % 2 == 1) {
                right--;
            }
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }

        return nums;
    }
}