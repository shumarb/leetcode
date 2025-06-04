// Question: https://leetcode.com/problems/minimum-pair-removal-to-sort-array-i/description/

class MinimumPairRemovalToSortArrayOne {
    public int minimumPairRemoval(int[] nums) {
        int count = 0;
        while (nums.length > 1 && !isNonDescending(nums)) {
            nums = update(nums);
            count++;
        }
        return count;
    }

    private int[] update(int[] nums) {
        int index = 0;
        int minimumSum = nums[0] + nums[1];
        int len = nums.length;
        int[] result = new int[len - 1];

        for (int i = 1; i < len - 1; i++) {
            int currentSum = nums[i] + nums[i + 1];
            if (currentSum < minimumSum) {
                index = i;
                minimumSum = currentSum;
            }
        }

        int j = 0;
        for (int i = 0; i < len;) {
            if (i == index) {
                result[j++] = minimumSum;
                i += 2;
            } else {
                result[j++] = nums[i++];
            }
        }

        return result;
    }

    private boolean isNonDescending(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}