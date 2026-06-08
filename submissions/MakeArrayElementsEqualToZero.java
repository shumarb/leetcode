// Question: https://leetcode.com/problems/make-array-elements-equal-to-zero/description/

class MakeArrayElementsEqualToZero {
    private int result;

    public int countValidSelections(int[] nums) {
        int n = nums.length;
        result = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int[] arr = new int[n];

                for (int j = 0; j < n; j++) {
                    arr[j] = nums[j];
                }
                dfs(i, arr, 0);
                if (isValid(arr)) {
                    result++;
                }

                arr = new int[n];
                for (int j = 0; j < n; j++) {
                    arr[j] = nums[j];
                }
                dfs(i, arr, 1);
                if (isValid(arr)) {
                    result++;
                }
            }
        }

        return result;
    }

    private void dfs(int curr, int[] nums, int direction) {
        if (curr < 0 || curr >= nums.length) {
            return;
        }

        int element = nums[curr];

        if (element == 0) {
            if (direction == 0) {
                dfs(curr - 1, nums, 0);
            } else {
                dfs(curr + 1, nums, 1);
            }

        } else if (element > 0) {
            nums[curr]--;
            if (direction == 0) {
                dfs(curr + 1, nums, 1);
            } else {
                dfs(curr - 1, nums, 0);
            }
        }
    }

    private boolean isValid(int[] arr) {
        for (int e: arr) {
            if (e != 0) {
                return false;
            }
        }

        return true;
    }
}
