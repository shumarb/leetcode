// Question: https://leetcode.com/problems/minimum-swaps-to-move-zeros-to-end/description/

class MinimumSwapsToMoveZerosToEnd {
    public int minimumSwaps(int[] nums) {
        boolean isTest = false;
        int left = 0;
        int n = nums.length;
        int result = 0;
        int right = n - 1;

        if (isTest) {
            System.out.println("before, nums: " + Arrays.toString(nums));
        }

        while (left < right) {
            while (left < n && nums[left] != 0) {
                left++;
            }

            while (right >= 0 && nums[right] == 0) {
                right--;
            }

            if (left >= 0 && right < n && left < right && nums[left] == 0 && nums[right] != 0) {
                if (isTest) {
                    System.out.println(" * swap @ indices [" + left + ", " + right + "]");
                }
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                result++;
            }

            left++;
            right--;
        }

        if (isTest) {
            System.out.println("after, nums: " + Arrays.toString(nums));
        }

        return result;
    }
}
