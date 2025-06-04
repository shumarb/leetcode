// Question: https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/description/

class LargestPositiveIntegerThatExistsWithItsNegative {
    public int findMaxK(int[] nums) {
        int largestPositiveInteger = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();

        for (int number: nums) {
            int complement = number * -1;
            if (set.contains(number * -1) && Math.abs(number) > largestPositiveInteger) {
                largestPositiveInteger = Math.abs(number);
            }
            set.add(number);
        }

        return largestPositiveInteger == Integer.MIN_VALUE ? -1 : largestPositiveInteger;
    }
}