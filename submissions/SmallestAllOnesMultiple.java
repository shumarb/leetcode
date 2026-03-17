// Question: https://leetcode.com/problems/smallest-all-ones-multiple/description/

class SmallestAllOnesMultiple {
    public int minAllOneMultiple(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }

        boolean isTest = false;
        int remainder = 0;
        for (int len = 1; len <= k; len++) {
            remainder = (remainder * 10 + 1) % k;
            if (isTest) {
                System.out.println(" * len: " + len + " | remainder: " + remainder);
            }

            if (remainder == 0) {
                return len;
            }
        }

        return -1;
    }
}