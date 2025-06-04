// Question: https://leetcode.com/problems/calculate-money-in-leetcode-bank/description/

class CalculateMoneyInLeetcodeBank {
    public int totalMoney(int n) {
        boolean[] isMonday = new boolean[n + 1];
        int[] money = new int[n + 1];
        int sum = 1;
        money[1] = 1;
        isMonday[1] = true;

        for (int i = 2; i <= n; i++) {
            if (i - 7 >= 1 && isMonday[i - 7]) {
                money[i] = 1 + money[i - 7];
                isMonday[i] = true;
            } else {
                money[i] = 1 + money[i - 1];
            }
            sum += money[i];
        }

        return sum;
    }
}