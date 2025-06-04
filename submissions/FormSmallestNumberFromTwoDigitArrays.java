// Question: https://leetcode.com/problems/form-smallest-number-from-two-digit-arrays/description/

class FormSmallestNumberFromTwoDigitArrays {
    public int minNumber(int[] nums1, int[] nums2) {
        int[] numberFrequency = new int[10];
        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int number: nums1) {
            numberFrequency[number]++;
            firstSmallest = Math.min(firstSmallest, number);
        }
        for (int number: nums2) {
            numberFrequency[number]++;
            secondSmallest = Math.min(secondSmallest, number);
        }

        for (int i = 1; i < numberFrequency.length; i++) {
            if (numberFrequency[i] == 2) {
                return i;
            }
        }

        return (firstSmallest < secondSmallest) ? firstSmallest * 10 + secondSmallest : secondSmallest * 10 + firstSmallest;
    }
}