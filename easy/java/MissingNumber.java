// Question: https://leetcode.com/problems/missing-number/description/

class MissingNumber {
    public int missingNumber(int[] nums) {
        int max = 0;
        boolean isTest = false;

        for (int number: nums) {
            max = Math.max(max, number);
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nmax: " + max);
        }

        boolean[] freqArr = new boolean[max + 1];
        for (int number: nums) {
            freqArr[number] = true;
        }
        if (isTest) {
            System.out.println("freqArr: " + Arrays.toString(freqArr));
        }
        for (int i = 0; i < freqArr.length; i++) {
            if (!freqArr[i]) {
                return i;
            }
        }

        // If nums array contains values in range [0, max]
        return max + 1;
    }
}