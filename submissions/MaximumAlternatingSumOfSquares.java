// Question: https://leetcode.com/problems/maximum-alternating-sum-of-squares/description/

class MaximumAlternatingSumOfSquares {
    public long maxAlternatingSum(int[] nums) {
        boolean isTest = false;
        int[] count = new int[40001];
        int j = 0;
        int left = 0;
        int n = nums.length;
        int right = n - 1;
        long result = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                nums[i] *= -1;
            }
        }
        for (int e: nums) {
            count[e]++;
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                nums[j++] = i;
            }
        }
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums) + "\n--------------------------------");
        }

        while (left <= right) {
            long element = nums[right];
            long add = element * element;
            if (isTest) {
                System.out.println(" * element: " + element + " | +" + add);
            }

            result += add;

            if (left == right--) {
                break;
            }

            element = nums[left++];
            long subtract = element * element;
            if (isTest) {
                System.out.println(" * element: " + element + " | -" + subtract);
            }

            result -= subtract;
        }

        if (isTest) {
            System.out.println("--------------------------------\nresult: " + result);
        }

        return result;
    }
}
