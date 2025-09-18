// Question: https://leetcode.com/problems/smallest-absent-positive-greater-than-average/description/

class SmallestAbsentPositiveGreaterThanAverage {
    public int smallestAbsent(int[] nums) {
        Set<Integer> set = new HashSet<>();
        boolean isTest = false;
        int average = 0;
        int smallest = 1;

        for (int number: nums) {
            if (number > 0) {
                set.add(number);
            }
            average += number;
        }
        average /= nums.length;
        smallest = Math.max(average, 0) + 1;
        if (isTest) {
            System.out.println("set: " + set + "\naverage: " + average + "\ninitial smallest: " + smallest);
        }
        while (set.contains(smallest)) {
            smallest++;
        }
        if (isTest) {
            System.out.println("final smallest: " + smallest);
        }

        return smallest;
    }
}