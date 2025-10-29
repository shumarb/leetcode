// Question: https://leetcode.com/problems/remove-zeros-in-decimal-representation/description/

class RemoveZerosInDecimalRepresentation {
    public long removeZeros(long n) {
        long multiplier = 1;
        long result = 0;

        while (n > 0) {
            long digit = n % 10;
            if (digit != 0) {
                result = result + digit * multiplier;
                multiplier *= 10;
            }
            n /= 10;
        }

        return result;
    }
}