// Question: https://leetcode.com/problems/lemonade-change/description/

class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;

        for (int bill: bills) {
            if (bill == 5) {
                count5++;

            } else if (bill == 10) {
                // 1. For $10 bill, return one $5 bill.
                if (count5 >= 1) {
                    count10++;
                    count5--;

                } else {
                    return false;
                }

            } else {
                /**
                 2.  For $20 bill, return either
                     - three $5 bills.
                     - one $5 & one $10 bills.
                     Prioritize giving one $5 and one $10 as more notes are available for future exchanges.
                 */
                if (count5 >= 1 && count10 >= 1) {
                    count5--;
                    count10--;

                } else if (count5 >= 3) {
                    count5 -= 3;

                } else {
                    return false;
                }
            }
        }

        return true;
    }
}