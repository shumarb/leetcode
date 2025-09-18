// Question: https://leetcode.com/problems/smallest-absent-positive-greater-than-average/description/

class SmallestAbsentPositiveGreaterThanAverage {
    public int smallestAbsent(int[] nums) {
        boolean[] isPresent = new boolean[102];
        boolean isTest = false;
        int average = 0;
        int smallest;

        for (int number: nums) {
            if (number > 0) {
                isPresent[number] = true;
            }
            average += number;
        }
        average /= nums.length;
        smallest = Math.max(average, 0) + 1;
        if (isTest) {
            System.out.println("\naverage: " + average + "\ninitial smallest: " + smallest);
        }

        while (isPresent[smallest]) {
            smallest++;
        }
        if (isTest) {
            System.out.println("final smallest: " + smallest);
        }

        return smallest;
    }
}