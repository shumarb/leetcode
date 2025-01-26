// Question: https://leetcode.com/problems/richest-customer-wealth/description/

class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int maximumWealth = 0;
        for (int[] customer: accounts) {
            int currentWealth = 0;
            for (int money: customer) {
                currentWealth += money;
            }
            maximumWealth = Math.max(currentWealth, maximumWealth);
        }
        return maximumWealth;
    }
}
