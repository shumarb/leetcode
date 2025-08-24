// Question: https://leetcode.com/problems/fair-candy-swap/description/

class FairCandySwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        Set<Integer> bobSet = new HashSet<>();
        boolean isTest = false;
        int[] result = new int[2];
        int totalAlice = 0;
        int totalBob = 0;
        int totalComplement = 0;

        for (int candy: aliceSizes) {
            totalAlice += candy;
        }
        for (int candy: bobSizes) {
            bobSet.add(candy);
            totalBob += candy;
        }
        totalComplement = (totalBob - totalAlice) / 2;

        for (int candy: aliceSizes) {
            if (bobSet.contains(candy + totalComplement)) {
                result[0] = candy;
                result[1] = candy + totalComplement;
                break;
            }
        }
        if (isTest) {
            System.out.println("totalAlice: " + totalAlice + "\ntotalBob: " + totalBob);
            System.out.println("totalComplement: " + totalComplement + "\nbobSet: " + bobSet);
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}