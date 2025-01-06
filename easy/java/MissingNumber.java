// Question: https://leetcode.com/problems/missing-number/description/

class MissingNumber {
    public int missingNumber(int[] nums) {
        boolean isTest = false;
        int[] freq = new int[nums.length + 1];
        int max = 0;
        int min = 0;
        if (isTest) {
            System.out.println("freq: " + Arrays.toString(freq));
        }
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        if (isTest) {
            System.out.println("freq: " + Arrays.toString(freq) + ", max: " + max + ", min: " + min);
        }
        for (int i = min; i <= max; i++) {
            if (freq[i] == 0) {
                if (isTest) {
                    System.out.println("missing: " + i);
                }
                return i;
            }
        }
        return max + 1;
    }
}
