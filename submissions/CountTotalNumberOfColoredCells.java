// Question: https://leetcode.com/problems/count-total-number-of-colored-cells/description/

class CountTotalNumberOfColoredCells {
    public long coloredCells(int n) {
        /**
         1 -> 1:  1^2 + 0^2
         2 -> 5:  2^2 + 1^2
         3 -> 13: 3^2 + 2^2
         4 -> 24: 4^2 + 3^2
         5 -> 41: 5^2 + 4^2
         */
        boolean isTest = false;
        long limit = (long) n;
        long result = 0l;

        for (long current = 1; current <= limit; current++) {
            result = current * current + (current - 1) * (current - 1);
            if (isTest) {
                System.out.println(" * " + current + ": " + result);
            }
        }
        if (isTest) {
            System.out.println("-------------------------\nresult: " + result);
        }

        return result;
    }
}
