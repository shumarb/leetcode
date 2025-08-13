// Question: https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/description/

class RemoveDigitFromNumberToMaximizeResult {
    public String removeDigit(String number, char digit) {
        String result = "";
        boolean isTest = false;

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                String newNumber = number.substring(0, i) + number.substring(i + 1, number.length());
                if (isTest) {
                    System.out.println("newNumber: " + newNumber + "\n * before, result: " + result);
                }
                if (newNumber.compareTo(result) > 0) {
                    result = newNumber;
                }
                if (isTest) {
                    System.out.println(" * after, result: " + result);
                    System.out.println("-----------------------------------------------------");
                }
            }
        }

        return result;
    }
}