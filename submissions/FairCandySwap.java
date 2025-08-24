// Question: https://leetcode.com/problems/fair-candy-swap/description/

class FairCandySwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        boolean[] isBobCandyPresent = new boolean[100001];
        boolean isTest = false;
        int[] result = new int[2];
        int totalAlice = 0;
        int totalBob = 0;
        int totalComplement = 0;

        for (int candy: aliceSizes) {
            totalAlice += candy;
        }
        for (int candy: bobSizes) {
            isBobCandyPresent[candy] = true;
            totalBob += candy;
        }
        totalComplement = (totalBob - totalAlice) / 2;

        for (int candy: aliceSizes) {
            int toFind = candy + totalComplement;
            if (toFind >= 1 && toFind <= 100000 && isBobCandyPresent[toFind]) {
                result[0] = candy;
                result[1] = candy + totalComplement;
                break;
            }
        }
        if (isTest) {
            System.out.println("aliceSizes: " + Arrays.toString(aliceSizes) + "\nbobSizes: " + Arrays.toString(bobSizes));
            System.out.println("totalAlice: " + totalAlice + "\ntotalBob: " + totalBob);
            System.out.println("totalComplement: " + totalComplement + "\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}