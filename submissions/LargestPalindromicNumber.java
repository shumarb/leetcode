// Question: https://leetcode.com/problems/largest-palindromic-number/description/

class LargestPalindromicNumber {
    public String largestPalindromic(String num) {
        String center = "";
        String right = "";
        StringBuilder left = new StringBuilder();
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        int[] frequency = new int[10];

        for (char digit: num.toCharArray()) {
            frequency[digit - '0']++;
        }
        if (isTest) {
            System.out.println("num: " + num + "\nbefore, frequency: " + Arrays.toString(frequency));
            System.out.println("-----------------------------------------------------------------------------");
        }

        for (int digit = 9; digit >= 0; digit--) {
            while (frequency[digit] >= 2) {
                /**
                    1.  Edge case: Num comprises of only zeros,
                        so the answer is 0.
                 */
                if (digit == 0 && left.isEmpty()) {
                    break;
                }

                /**
                    2.  Add digit to left, and since digits in left are in right,
                        reduce frequency by 2.
                 */
                left.append(digit);
                frequency[digit] -= 2;
            }
        }

        /**
            3.  Center is either empty or 1 digit, which is the largest digit with frequency of 1 after earlier iteration.
         */
        for (int digit = 9; digit >=0 ; digit--) {
            if (frequency[digit] == 1) {
                center = String.valueOf(digit);
                break;
            }
        }

        right = left.reverse().toString();
        left.reverse();
        result = left.append(center).append(right);
        if (isTest) {
            System.out.println("after, frequency: " + Arrays.toString(frequency));
            System.out.println("left: " + left + "\ncenter: " + center + "\nright: " + right);
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("result: " + result);
        }

        return result.isEmpty() ? "0" : result.toString();
    }
}