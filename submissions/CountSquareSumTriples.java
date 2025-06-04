// Question: https://leetcode.com/problems/count-square-sum-triples/description/

class CountSquareSumTriples {
    public int countTriples(int n) {
        int count = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = a; b <= n; b++) {
                for (int c = b; c <= n; c++) {
                    if (((a * a) + (b * b)) == (c * c)) {
                        count++;
                    }
                }
            }
        }

        /**
         1.  Double count by 2 to count b ^ 2 + a ^ 2 == c ^ 2,
             because calculation above only considers a ^ 2 + b ^ 2 == c ^ 2.
         */
        return count * 2;
    }
}