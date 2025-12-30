// Question: https://leetcode.com/problems/intersection-of-two-arrays/description/

class IntersectionOfTwoArraysTwo {
    public int[] intersect(int[] nums1, int[] nums2) {
        boolean isTest = false;
        int[] count = new int[1001];
        int[] result = new int[1001];
        int total = 0;

        for (int e: nums1) {
            count[e]++;
        }
        for (int e: nums2) {
            if (count[e]-- > 0) {
                result[total++] = e;
            }
        }
        result = Arrays.copyOfRange(result, 0, total);
        if (isTest) {
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}