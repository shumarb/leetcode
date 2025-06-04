// Question: https://leetcode.com/problems/account-balance-after-rounded-purchase/description/

class AccountBalanceAfterRoundedPurchase {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        return 100 - ((int) Math.round(purchaseAmount / 10.0) * 10);
    }
}