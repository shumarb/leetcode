// Question: https://leetcode.com/problems/ant-on-the-boundary/description/

class AntOnTheBoundary {
    public int returnToBoundaryCount(int[] nums) {
        int count = 0;
        int position = 0;
        for (int number: nums) {
            position += number;
            // 1. Ant returns to boundary when position == 0.
            if (position == 0) {
                count++;
            }
        }
        return count;
    }
}