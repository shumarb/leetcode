// Question: https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/description/

class ReductionOperationsToMakeTheArrayElementsEqual {
    public int reductionOperations(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        /**
         1.  Count set to 1 as we counted maximum element.
             Count counts the number of times the maximum element appears.
         */
        int count = 1;
        int operations = 0;
        boolean isTest = false;
        Arrays.sort(nums);
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums));
        }

        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] != nums[i - 1]) {
                operations += count;
            }
            count++;
        }
        if (isTest) {
            System.out.println("count: " + count + "\noperations: " + operations);
        }

        return operations;
    }
}