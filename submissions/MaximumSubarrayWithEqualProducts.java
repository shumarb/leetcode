// Question: https://leetcode.com/problems/maximum-subarray-with-equal-products/description/

class MaximumSubarrayWithEqualProducts {
    public int maxLength(int[] nums) {
        boolean isTest = false;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (isTest) {
                System.out.println("---------------------------------");
            }
            for (int j = i; j < nums.length; j++) {
                int[] sub = Arrays.copyOfRange(nums, i, j + 1);

                int gcd = sub[0];
                int lcm = sub[0];
                int product = 1;

                for (int e: sub) {
                    product *= e;
                }
                for (int k = 1; k < sub.length; k++) {
                    gcd = gcd(gcd, sub[k]);
                    lcm = lcm(lcm, sub[k]);
                }
                if (product == gcd * lcm) {
                    result = Math.max(result, sub.length);
                }
                if (isTest) {
                    System.out.println("sub: " + Arrays.toString(sub) + " -> gcd: " + gcd + ", lcm: " + lcm + ", product: " + product);
                }
            }
        }
        if (isTest) {
            System.out.println("---------------------------------\nresult: " + result);
        }

        return result;
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}