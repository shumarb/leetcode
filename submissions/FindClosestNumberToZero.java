// Question: https://leetcode.com/problems/find-closest-number-to-zero/description/

class FindClosestNumberToZero {
    public int findClosestNumber(int[] nums) {
        int closestNumber = nums[0];
        int smallestAbsoluteValue = Math.abs(nums[0]);
        for (int number: nums) {
            if (Math.abs(number) < smallestAbsoluteValue) {
                smallestAbsoluteValue = Math.abs(number);
                closestNumber = number;
            } else if (Math.abs(number) == smallestAbsoluteValue && number > closestNumber) {
                closestNumber = number;
            }
        }
        return closestNumber;
    }
}