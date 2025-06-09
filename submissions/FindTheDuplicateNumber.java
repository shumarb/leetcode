// Question: https://leetcode.com/problems/find-the-duplicate-number/description/

class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        boolean isTest = false;

        for (int i = 0; i < nums.length; i++) {
            int absoluteElement = Math.abs(nums[i]);
            if (isTest) {
                System.out.println("-----------------------------");
                System.out.println("i: " + i + " | absoluteElement: " + absoluteElement);
                System.out.println(" * before: " + Arrays.toString(nums));
            }
            if (nums[absoluteElement] < 0) {
                return absoluteElement;
            }
            nums[absoluteElement] *= -1;
            if (isTest) {
                System.out.println(" * after:  " + Arrays.toString(nums));
            }
        }

        return -1; // dummy value.
    }
}