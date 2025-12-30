// Question: https://leetcode.com/problems/intersection-of-two-arrays/description/

class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] isPresent = new boolean[1001];
        int[] result = new int[1001];
        int total = 0;

        for (int e: nums1) {
            isPresent[e] = true;
        }
        for (int e: nums2) {
            if (isPresent[e]) {
                result[total++] = e;
                isPresent[e] = false;
            }
        }

        return Arrays.copyOfRange(result, 0, total);
    }
}