// Question: https://leetcode.com/problems/distribute-candies-among-children-i/description/

class DistributeCandiesAmongChildrenOne {
    public int distributeCandies(int n, int limit) {
        boolean isTest = false;
        int total = 0;
        int upperBound = Math.min(n, limit);

        for (int i = 0; i <= upperBound; i++) {
            for (int j = 0; j <= upperBound; j++) {
                for (int k = 0; k <= upperBound; k++) {
                    if (i + j + k == n) {
                        total++;
                        if (isTest) {
                            System.out.println(" * valid | i: " + i + ", j: " + j + ", k: " + k + " -> total: " + total);
                        }
                    }
                }
            }
        }

        return total;
    }
}