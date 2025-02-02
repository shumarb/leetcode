// Question: https://leetcode.com/problems/find-target-indices-after-sorting-array/description/

class FindTargetIndicesAfterSortingArray {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        boolean isTest = false;
        int startIndexOfTarget = 0;
        int countTarget = 0;

        for (int element: nums) {
            if (element < target) {
                startIndexOfTarget++;
            }
            if (element == target) {
                countTarget++;
            }
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\ntarget: " + target);
            System.out.println("startIndexOfTarget: " + startIndexOfTarget + ", countTarget: " + countTarget);
        }

        while (countTarget != 0) {
            result.add(startIndexOfTarget++);
            countTarget--;
        }

        if (isTest) {
            System.out.println("result: " + result);
        }
        return result;
    }
}