// Question: https://leetcode.com/problems/arranging-coins/description/

class ArrangingCoins {
    public int arrangeCoins(int n) {
        List<Integer> list = new ArrayList<>();
        boolean isTest = false;
        int nCopy = n;
        int numCoins = 1;
        int result = 0;

        while (nCopy > 0) {
            if (isTest) {
                System.out.println("before:\n * nCopy: " + nCopy + "\n * numCoins: " + numCoins + "\n * list: " + list);
            }
            if (numCoins > nCopy) {
                if (isTest) {
                    System.out.println("-------------------------------------------------");
                }
                break;
            }
            list.add(numCoins);
            nCopy -= numCoins++;
            if (isTest) {
                System.out.println("\nafter:\n * nCopy: " + nCopy + "\n * list: " + list);
                System.out.println("-------------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("n: " + n + "\nnCopy: " + nCopy + "\nlist: " + list + ", result: " + list.size());
        }

        return list.size(); // exclude 0;
    }
}