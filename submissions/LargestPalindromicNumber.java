// Question: https://leetcode.com/problems/largest-palindromic-number/description/

class LargestPalindromicNumber {
    public String largestPalindromic(String num) {
        String center = "";
        String right = "";
        StringBuilder result = new StringBuilder();
        StringBuilder left = new StringBuilder();
        boolean isTest = false;
        int[] frequency = new int[10];

        for (char digit: num.toCharArray()) {
            frequency[digit - '0']++;
        }
        if (isTest) {
            System.out.println("num: " + num + "\nbefore, frequency: " + Arrays.toString(frequency));
        }

        for (int digit = 9; digit >= 0; digit--) {
            while (frequency[digit] >= 2) {
                /**
                 1.  Edge case: num comprises of only zeros.
                     Left is empty. It can't be appended with zeros
                     as this means leading zeros are counted, so break.
                 */
                if (digit == 0 && left.isEmpty()) {
                    break;
                }
                left.append(digit);
                frequency[digit] -= 2;
            }
        }

        /**
         2.  Search for center digit (if any). It is the largest digit with frequency == 1.
             At this point, remaining frequency of each digit is either 0 or 1.
         */
        for (int digit = 9; digit >= 0; digit--) {
            if (frequency[digit] == 1) {
                center = Integer.toString(digit);
                break;
            }
        }

        right = left.reverse().toString();
        left.reverse();
        if (isTest) {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("after, frequency: " + Arrays.toString(frequency));
            System.out.println("left: " + left + "\ncenter: " + center + "\nright: " + right);
        }
        result = left.append(center).append(right);
        if (isTest) {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("result: " + result.toString());
        }

        return result.isEmpty() ? "0" : result.toString();
    }
}