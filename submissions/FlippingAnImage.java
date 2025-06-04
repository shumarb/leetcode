// Question: https://leetcode.com/problems/flipping-an-image/description/

class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            image[i] = reverse(image[i]);
        }
        for (int i = 0; i < image.length; i++) {
            image[i] = invert(image[i]);
        }
        return image;
    }

    private int[] invert(int[] row) {
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 1) {
                row[i] = 0;
            } else {
                row[i] = 1;
            }
        }
        return row;
    }

    private int[] reverse(int[] row) {
        int left = 0;
        int right = row.length - 1;
        while (left < right) {
            int temp = row[left];
            row[left++] = row[right];
            row[right--] = temp;
        }
        return row;
    }
}