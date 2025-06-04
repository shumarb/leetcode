// Question: https://leetcode.com/problems/find-all-duplicates-in-an-array/description/

class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        // 1. Edge case: 1 element, so no duplicate elements.
        if (nums.length == 1) {
            return new ArrayList<>();
        }

        boolean isTest = false;
        List<Integer> result = new ArrayList<>();

        if (isTest) {
            System.out.println("before, nums: " + Arrays.toString(nums));
        }
        for (int i = 0; i < nums.length; i++) {
            // 1. Reduce by 1 due to 0-based indexing and elements are 1-based indexing.
            int index = Math.abs(nums[i]) - 1;

            /** 2.  If element at index is negative,
             then index is a duplicate.
             */
            if (nums[index] < 0) {
                result.add(index + 1);

                /**
                 3.  Mark number as visited
                 by setting it as negative value of itself.
                 */
            } else {
                nums[index] *= -1;
            }
        }
        if (isTest) {
            System.out.println("after, nums: " + Arrays.toString(nums));
        }

        return result;
    }
}