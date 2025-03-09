// Question: https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/description/

class CountElementsWithStrictlySmallerAndGreaterElements {
    public int countElements(int[] nums) {
        int count = 0;
        int maximum = nums[0];
        int minimum = nums[0];

        for (int number: nums) {
            maximum = Math.max(maximum, number);
            minimum = Math.min(minimum, number);
        }

        for (int number: nums) {
            if (number > minimum && number < maximum) {
                count++;
            }
        }

        return count;
    }
}