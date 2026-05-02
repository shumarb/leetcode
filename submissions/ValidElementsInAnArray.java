// Question: https://leetcode.com/problems/valid-elements-in-an-array/description/

class ValidElementsInAnArray {
    private boolean isTest;

    public List<Integer> findValidElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        isTest = false;

        // 1. Edge case: single element.
        if (n == 1) {
            return List.of(nums[0]);
        }

        result.add(nums[0]);
        for (int i = 1; i < n - 1; i++) {
            if (isValid(nums, i)) {
                result.add(nums[i]);
            }
        }
        result.add(nums[n - 1]);

        return result;
    }

    private boolean isValid(int[] nums, int i) {
        boolean isGreaterThanLeft = true;
        boolean isGreaterThanRight = true;
        int number = nums[i];

        if (isTest) {
            System.out.println("-----------------------------------------\ni: " + i + " -> number: " + number);
        }
        for (int j = 0; j < i; j++) {
            if (isTest) {
                System.out.println(" * compare | number: " + number + ", current: " + nums[j]);
            }
            if (nums[j] >= nums[i]) {
                isGreaterThanLeft = false;
                break;
            }
        }
        if (isGreaterThanLeft) {
            return true;
        }

        for (int j = i + 1; j < nums.length; j++) {
            if (isTest) {
                System.out.println(" * compare | number: " + number + ", current: " + nums[j]);
            }
            if (nums[j] >= nums[i]) {
                return false;
            }
        }

        return true;
    }
}
