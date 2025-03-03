// Question: https://leetcode.com/problems/height-checker/description/

class Solution {
    public int heightChecker(int[] heights) {
        int len = heights.length;
        int count = 0;
        int[] expected = new int[len];
        boolean isTest = false;

        for (int i = 0; i < len; i++) {
            expected[i] = heights[i];
        }
        Arrays.sort(expected);
        if (isTest) {
            System.out.println("heights: " + Arrays.toString(heights) + "\nexpected: " + Arrays.toString(expected));
        }

        // 1. Students are arranged in non-descreasing height.
        if (Arrays.equals(expected, heights)) {
            return 0;
        }

        for (int i = 0; i < len; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        if (isTest) {
            System.out.println("count: " + count);
        }

        return count;
    }
}