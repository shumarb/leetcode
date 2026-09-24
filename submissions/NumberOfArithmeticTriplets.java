// Question: https://leetcode.com/problems/number-of-arithmetic-triplets/description/

class NumberOfArithmeticTriplets {
    public int arithmeticTriplets(int[] nums, int diff) {
        boolean[] isPresent = new boolean[201];
        boolean isTest = false;
        int result = 0;

        if (isTest) {
            System.out.println("diff: " + diff + "\nnums: " + Arrays.toString(nums));
            System.out.println("----------------------------------");
        }
        for (int i = 0; i < nums.length; i++) {
            int third = nums[i];
            int first = third - 2 * diff;
            int second = third - diff;
            isPresent[third] = true;

            if (first >= 0 && second >= 0 && isPresent[first] && isPresent[second]) {
                if (isTest) {
                    System.out.println(" * valid: [" + first + ", " + second + ", " + third + "]");
                }

                result++;
            }
        }
        if (isTest) {
            System.out.println("----------------------------------\nresult: " + result);
        }

        return result;
    }
}
