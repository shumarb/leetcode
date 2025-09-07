// Question: https://leetcode.com/problems/distribute-candies-among-children-i/description/

class DistributeCandiesAmongChildrenOne {
    public int distributeCandies(int n, int limit) {
        boolean isTest = false;
        int total = 0;

        for (int i = 0; i <= n; i++) {
            if (i > limit) {
                continue;
            }
            for (int j = 0; j <= n; j++) {
                if (j > limit) {
                    continue;
                }
                for (int k = 0; k <= n; k++) {
                    if (k > limit) {
                        continue;
                    }
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