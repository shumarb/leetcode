// Question: https://leetcode.com/problems/find-the-integer-added-to-array-i/description/

class FindTheIntegerAddedToArrayOne {
    public int addedInteger(int[] nums1, int[] nums2) {
        int minimum1 = Integer.MAX_VALUE;
        int minimum2 = Integer.MAX_VALUE;

        for (int number: nums1) {
            minimum1 = Math.min(minimum1, number);
        }
        for (int number: nums2) {
            minimum2 = Math.min(minimum2, number);
        }

        return minimum2 - minimum1;
    }
}