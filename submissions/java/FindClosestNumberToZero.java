// Question: https://leetcode.com/problems/find-closest-number-to-zero/description/

class FindClosestNumberToZero {
    public int findClosestNumber(int[] nums) {
        int closestNumber = nums[0];
        for (int number: nums) {
            if (Math.abs(number) < Math.abs(closestNumber)) {
                closestNumber = number;
            } else if (Math.abs(number) == Math.abs(closestNumber) && number > closestNumber) {
                closestNumber = number;
            }
        }
        return closestNumber;
    }
}