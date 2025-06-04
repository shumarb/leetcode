// Question: https://leetcode.com/problems/maximum-odd-binary-number/description/

class MaximumOddBinaryNumber {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        int countZero = 0;
        int countOne = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                countZero++;
            } else {
                countOne++;
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\ncountZero: " + countZero + "\ncountOne: " + countOne);
        }

        if (countOne > 1) {
            for (int i = 0; i < countOne - 1; i++) {
                result.append('1');
            }
            for (int i = 0; i < countZero; i++) {
                result.append('0');
            }
            result.append('1');
        } else {
            for (int i = 0; i < countZero; i++) {
                result.append('0');
            }
            result.append('1');
        }
        if (isTest) {
            System.out.println("result: " + result.toString());
        }
        return result.toString();
    }
}