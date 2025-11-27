// Question: https://leetcode.com/problems/maximum-subarray-with-equal-products/description/

class MaximumSubarrayWithEqualProducts {
    public int maxLength(int[] nums) {
        boolean isTest = false;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (isTest) {
                System.out.println("---------------------------------");
            }

            long product = 1;
            int gcd = 0;
            long lcm = 1;

            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                gcd = findGcd(gcd, nums[j]);
                lcm = findLcm(lcm, nums[j]);

                if (product == (long) (gcd * lcm)) {
                    result = Math.max(result, j - i + 1);
                }
                if (isTest) {
                    System.out.println("arr: " + Arrays.toString(Arrays.copyOfRange(nums, i, j + 1)) + " --> gcd: " + gcd + ", lcm: " + lcm + ", product: " + product);
                }
            }
        }
        if (isTest) {
            System.out.println("---------------------------------\nresult: " + result);
        }

        return result;
    }

    private long findLcm(long a, long b) {
        if (a == 0 || b == 0) {
            return Math.max(a, b);
        }
        return a / findGcd((int) a, (int) b) * b;
    }

    private int findGcd(int a, int b) {
        return b == 0 ? a : findGcd(b, a % b);
    }
}