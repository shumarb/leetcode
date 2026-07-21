// Question: https://leetcode.com/problems/number-of-ways-to-buy-pens-and-pencils/description/

class NumberOfWaysToBuyPensAndPencils {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        int maximumPens = total / cost1;
        long result = 0;

        for (int pens = 0; pens <= maximumPens; pens++) {
            int balance = total - pens * cost1;
            result += (balance / cost2 + 1);
        }

        return result;
    }
}
