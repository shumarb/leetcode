// Question: https://leetcode.com/problems/distribute-money-to-maximum-children/description/

class DistributeMoneyToMaximumChildren {
    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }

        boolean isTest = false;
        int[] moneyPerChild = new int[children];
        int i = 0;
        int n = children;
        int result = 0;

        money -= children;
        Arrays.fill(moneyPerChild, 1);
        for (; i < n && money >= 7; i++) {
            moneyPerChild[i] += 7;
            money -= 7;
            result++;
        }

        if (isTest) {
            System.out.println("moneyPerChild: " + Arrays.toString(moneyPerChild) + "\nbalance: " + money + "\ni: " + i + "\nresult: " + result);
        }

        // 1. All monies distributed and number of children getting $8 is maximized.
        if (money == 0) {
            return result;

        } else if (money > 0 && ((result == children) || (money == 3 && children - result == 1))) {
            result--;
        }

        return result;
    }
}
