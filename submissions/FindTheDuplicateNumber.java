// Question: https://leetcode.com/problems/find-the-duplicate-number/description/

class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        boolean isTest = false;

        for (int i = 0; i < nums.length; i++) {
            /**
             1.  Each element represents an index in the array.
                 If it is negative, retrieve its absolute value.
             */
            int indexToCheck = Math.abs(nums[i]);
            if (isTest) {
                System.out.println("-----------------------------");
                System.out.println("i: " + i + " | indexToCheck: " + indexToCheck);
                System.out.println(" * before: " + Arrays.toString(nums));
            }

            /**
             2.  If the element at indexToCheck is negative,
                 indexToCheck has been checked before,
                 thus the duplicate number is indexToCheck.
             */
            if (nums[indexToCheck] < 0) {
                return indexToCheck;
            }

            /**
             3.  Set element to its negative to denote this index has been checked.
             */
            nums[indexToCheck] *= -1;
            if (isTest) {
                System.out.println(" * after:  " + Arrays.toString(nums));
            }
        }

        return -1; // 4. dummy value.
    }
}