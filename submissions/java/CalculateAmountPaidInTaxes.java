// Question: https://leetcode.com/problems/calculate-amount-paid-in-taxes/description/

class CalculateAmountPaidInTaxes {
    public double calculateTax(int[][] brackets, int income) {
        double tax = 0;
        double incomeValue = income;
        double previousUpper = 0;

        for (int i = 0; i < brackets.length && incomeValue > 0; i++) {
            double rate = (double) brackets[i][1] / 100.0;
            double currentUpper = brackets[i][0];
            double taxableAmount = currentUpper - previousUpper;
            tax += Math.min(taxableAmount, incomeValue) * rate;
            incomeValue -= taxableAmount;
            previousUpper = currentUpper;
        }

        return tax;
    }
}