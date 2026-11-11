// Question: https://leetcode.com/problems/minimum-number-game/description/

class MinimumNumberGame {
    public int[] numberGame(int[] nums) {
        sort(nums);

        for (int i = 0; i < nums.length; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }

        return nums;
    }

    private void sort(int[] nums) {
        int[] count = new int[101];
        int j = 0;

        for (int e: nums) {
            count[e]++;
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                nums[j++] = i;
            }
        }
    }
}
