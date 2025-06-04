// Question: https://leetcode.com/problems/largest-3-same-digit-number-in-string/description/

class Largest3SameDigitNumberInString {
    public String largestGoodInteger(String num) {
        String result = "";
        boolean isTest = false;
        int largest3SameDigit = -1;

        if (isTest) {
            System.out.println("num: " + num);
            System.out.println("---------------------------------------------------------");
        }
        for (int i = 0; i <= num.length() - 3; i++) {
            String current = "";
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                current = num.substring(i, i + 3);
                if (isTest) {
                    System.out.println("index: " + i);
                    System.out.println(" * before | result: " + result + ", current: " + current);
                }
                if (current.compareTo(result) > 0) {
                    result = current;
                }
                if (isTest) {
                    System.out.println(" * after  | result: " + result);
                    System.out.println("---------------------------------------------------------");
                }
            }
        }
        if (isTest) {
            System.out.println("result: " + result.toString());
        }

        return result;
    }
}