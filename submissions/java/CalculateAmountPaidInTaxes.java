// Question: https://leetcode.com/problems/calculate-amount-paid-in-taxes/description/

class CalculateAmountPaidInTaxes {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0;
        int numBrackets = brackets.length;

        for (int i = 0; i < numBrackets && income > 0; i++) {
            int amount = i == 0 ? brackets[i][0] : brackets[i][0] - brackets[i - 1][0];
            tax += (double) brackets[i][1] / 100.0 * (double) Math.min(amount, income);
            income -= amount;
        }

        return tax;
    }
}