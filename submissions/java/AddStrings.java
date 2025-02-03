// Question: https://leetcode.com/problems/add-strings/description/

class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int num1Ptr = num1.length() - 1;
        int num2Ptr = num2.length() - 1;
        boolean isTest = false;
        if (isTest) {
            System.out.println("num1: " + num1 + ", num2: " + num2);
        }

        int carryOver = 0;
        while (num1Ptr >= 0 || num2Ptr >= 0) {
            int num1Digit = (num1Ptr >= 0) ? Character.getNumericValue(num1.charAt(num1Ptr)) : 0;
            int num2Digit = (num2Ptr >= 0) ? Character.getNumericValue(num2.charAt(num2Ptr)) : 0;
            int sum = carryOver + num1Digit + num2Digit;

            if (isTest) {
                System.out.println("num1Digit: " + num1Digit + ", num2Digit: " + num2Digit + ", sum: " + sum);
            }

            if (sum < 9) {
                result.append(sum);
                carryOver = 0;
            } else {
                result.append(sum % 10);
                carryOver = sum / 10;
            }
            num1Ptr--;
            num2Ptr--;
        }
        if (carryOver > 0) {
            result.append(carryOver);
        }
        result = result.reverse();
        if (isTest) {
            System.out.println("result: " + result.toString() + ", carryOver: " + carryOver);
        }
        return result.toString();
    }
}