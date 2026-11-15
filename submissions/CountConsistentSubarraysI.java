// Question: https://leetcode.com/problems/count-consistent-subarrays-i/description/

class CountConsitentSubarraysI {
    public int countConsistent(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        int result = 0;

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\n-------------------------------------------");
        }
        for (int i = 0; i < n; i++) {
            int minimum = nums[i];
            int bitwiseAnd = nums[i];

            result++;

            for (int j = i + 1; j < n; j++) {
                int e = nums[j];
                bitwiseAnd &= e;
                minimum = Math.min(e, minimum);

                if (minimum == bitwiseAnd) {
                    if (isTest) {
                        System.out.println(" * indices: [" + i + ", " + j + "] | subarrays: " + Arrays.toString(Arrays.copyOfRange(nums, i, j + 1)));
                    }
                    result++;
                }
            }
        }
        if (isTest) {
            System.out.println("-------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
