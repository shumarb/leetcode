// Question: https://leetcode.com/problems/find-target-indices-after-sorting-array/description/

class FindTargetIndicesAfterSortingArray {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        boolean isTest = false;
        int startIndexOfTarget = 0;
        int countTarget = 0;

        for (int element: nums) {
            /**
             1. Count number of elements < target
             to identify start index of target when nums is sorted
             */
            if (element < target) {
                startIndexOfTarget++;
            }

            /**
             2. Count number of times target is in nums
             to know range of indices whose element is equal to target
             from aforementioned start index
             */
            if (element == target) {
                countTarget++;
            }
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\ntarget: " + target);
            System.out.println("startIndexOfTarget: " + startIndexOfTarget + ", countTarget: " + countTarget);
        }

        while (countTarget != 0) {
            /**
             3. Assuming nums is sorted,
             the target element is stored in a consecutive manner starting frmo startIndexOfTarget,
             so add incrementally from startIndexOfTarget by number of times target appears.
             Eg: [3 1 2 4 2], target = 2 ==> sorted: [1 2 2 3 4], target = 2.
             - start index of target (2) in sorted nums: 1,
             - number of times target appears is 2,
             ==> target indices are 1 & 2 ==> result {1, 2}.
             */
            result.add(startIndexOfTarget++);
            countTarget--;
        }

        if (isTest) {
            System.out.println("result: " + result);
        }
        return result;
    }
}