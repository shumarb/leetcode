// Question: https://leetcode.com/problems/maximum-height-of-a-triangle/description/

class MaximumHeightOfATriangle {
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(getMaximumHeight(red, blue), getMaximumHeight(blue, red));
    }

    private int getMaximumHeight(int first, int second) {
        int k = 1;
        int maxHeight = 0;

        while (true) {
            if (first - k < 0) {
                break;
            } else {
                first -= k;
                maxHeight++;
            }

            k++;

            if (second - k < 0) {
                break;
            } else {
                second -= k;
                maxHeight++;
            }

            k++;
        }

        return maxHeight;
    }
}