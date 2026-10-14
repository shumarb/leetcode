// Question: https://leetcode.com/problems/maximum-alternating-sum-of-squares/description/

class MaximumAlternatingSumOfSquares {
    public long maxAlternatingSum(int[] nums) {
        boolean isTest = false;
        int[] count = new int[40001];
        int j = 0;
        int left = 0;
        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;
        int n = nums.length;
        int right = n - 1;
        long result = 0;

        for (int e: nums) {
            if (e < 0) {
                e *= -1;
            }

            count[e]++;
            maximum = Math.max(e, maximum);
            minimum = Math.min(e, minimum);
        }
        for (int i = minimum; i <= maximum; i++) {
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
