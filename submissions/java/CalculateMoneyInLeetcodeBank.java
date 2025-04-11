// Question: https://leetcode.com/problems/calculate-money-in-leetcode-bank/description/

class CalculateMoneyInLeetcodeBank {
    public int totalMoney(int n) {
        boolean[] isMonday = new boolean[1001];
        int[] money = new int[n + 1];
        int i = 1;
        int sum = 1;

        money[i] = 1;
        while (i < isMonday.length) {
            isMonday[i] = true;
            i += 7;
        }

        for (i = 2; i <= n; i++) {
            if (isMonday[i]) {
                money[i] = 1 + money[i - 7];
            } else {
                money[i] = 1 + money[i - 1];
            }
            sum += money[i];
        }

        return sum;
    }
}