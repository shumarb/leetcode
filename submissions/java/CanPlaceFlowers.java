// Question: https://leetcode.com/problems/can-place-flowers/description/

class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean isTest = false;
        int len = flowerbed.length;

        if (isTest) {
            System.out.println("before | flowerbed: " + Arrays.toString(flowerbed) + ", n: " + n);
        }
        for (int i = 0; i < len && n > 0; i++) {
            if (flowerbed[i] == 0) {
                boolean isLeftEmpty = (i == 0 || flowerbed[i - 1] == 0);
                boolean isRightEmpty = (i == len - 1 || flowerbed[i + 1] == 0);
                if (isLeftEmpty && isRightEmpty) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        if (isTest) {
            System.out.println("after | flowerbed: " + Arrays.toString(flowerbed) + ", n: " + n);
        }

        return n == 0;
    }
}