// Question: https://leetcode.com/problems/remove-trailing-zeros-from-a-string/description/

class RemoveTrailingZerosFromAString {
    public String removeTrailingZeros(String num) {
        int i = num.length() - 1;

        // 1. Identify index of last non-zero value from the end of string.
        while (i >= 0 && num.charAt(i) == '0') {
            i--;
        }

        /**
         2.  Return num if no trailing zeroes,
         else return substring from index 0 to i.
         */
        return i == -1 ? num : num.substring(0, i + 1);
    }
}