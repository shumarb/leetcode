// Question: https://leetcode.com/problems/check-balanced-string/description/

class CheckedBalancedString {
    public boolean isBalanced(String num) {
        int sumEvenIndices = getSum(num, 0);
        int sumOddIndices = getSum(num, 1);
        return sumEvenIndices == sumOddIndices;
    }

    private int getSum(String num, int startIndex) {
        int sum = 0;
        for (int i = startIndex; i < num.length(); i += 2) {
            sum += Character.getNumericValue(num.charAt(i));
        }
        return sum;
    }
}