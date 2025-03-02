// Question: https://leetcode.com/problems/check-if-array-is-good/description/

class CheckIfArrayIsGood {
    public boolean isGood(int[] nums) {
        int maximum = nums[0];
        boolean isTest = false;

        for (int number: nums) {
            maximum = Math.max(maximum, number);
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nmaximum: " + maximum);
        }

        int[] base = new int[maximum + 1];
        base[base.length - 1] = maximum;
        base[base.length - 2] = maximum;
        for (int i = 0; i < base.length - 2; i++) {
            base[i] = i + 1;
        }
        if (isTest) {
            System.out.println("base: " + Arrays.toString(base));
        }

        if (base.length != nums.length) {
            return false;
        }
        Arrays.sort(nums);
        return Arrays.equals(base, nums);
    }
}