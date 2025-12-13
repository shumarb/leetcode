// Question: https://leetcode.com/problems/arranging-coins/description/

class ArrangingCoins {
    public int arrangeCoins(int n) {
        List<Integer> list = new ArrayList<>();
        boolean isTest = false;
        int nCopy = n;
        int totalCoins = 1;
        int completeRows = 0;
        int result = 0;

        while (nCopy - completeRows > 0) {
            if (isTest) {
                System.out.println(" * nCopy: " + nCopy + ", totalCoins: " + totalCoins + ", completeRows: " + completeRows);
            }
            nCopy -= totalCoins++;
            completeRows++;
        }
        if (isTest) {
            System.out.println("--------------------------------------------------------\nn: " + n + "\ncompleteRows: " + completeRows);
        }

        return completeRows;
    }
}