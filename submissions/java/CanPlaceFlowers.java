// Question: https://leetcode.com/problems/can-place-flowers/description/

class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean isTest = false;
        int len = flowerbed.length;

        if (isTest) {
            System.out.println("before | flowerbed: " + Arrays.toString(flowerbed) + ", n: " + n);
        }

        // 1. Edge case: n > number of flowers.
        if (n > len) {
            return false;
        }

        // 2. Edge case: Flowerbed has 1 plot and n == 1.
        if (len == 1 && n == 1) {
            return flowerbed[0] == 0;
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