// Question: https://leetcode.com/problems/valid-elements-in-an-array/description/

class ValidElementsInAnArray {
    public List<Integer> findValidElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        boolean isTest = false;
        int n = nums.length;

        // 1. Edge case: single element.
        if (n == 1) {
            return List.of(nums[0]);
        }

        result.add(nums[0]);
        for (int i = 1; i < n - 1; i++) {
            boolean isGreaterThanLeft = true;
            boolean isGreaterThanRight = true;
            int number = nums[i];

            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i]) {
                    isGreaterThanLeft = false;
                    break;
                }
            }

            for (int j = i + 1; j < n; j++) {
                if (nums[j] >= nums[i]) {
                    isGreaterThanRight = false;
                    break;
                }
            }

            if (isGreaterThanLeft || isGreaterThanRight) {
                result.add(number);
            }
        }
        result.add(nums[n - 1]);

        return result;
    }
}
