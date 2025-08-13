// Question: https://leetcode.com/problems/lemonade-change/description/

class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;
        int count20 = 0;

        for (int bill: bills) {
            if (bill == 5) {
                count5++;

            } else if (bill == 10) {
                /**
                 1.  To return $10 change,
                     so check if there is at least 1 $10 note.
                 */
                count10++;
                if (count5 > 0) {
                    count5--;

                } else {
                    return false;
                }

            } else {
                /**
                 1.  To return $15 change,
                     this is either: (one $10 + one $5, or three $5).
                 */
                count20++;
                if (count5 > 0 && count10 > 0) {
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