// Question: https://leetcode.com/problems/reformat-phone-number/description/

class ReformatPhoneNumber {
    public String reformatNumber(String number) {
        String digits;
        StringBuilder digitsSb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        int i = 0;
        int n;

        for (char c: number.toCharArray()) {
            if (Character.isDigit(c)) {
                digitsSb.append(c);
            }
        }
        if (isTest) {
            System.out.println("digitsSb: " + digitsSb);
        }

        digits = digitsSb.toString();
        n = digits.length();
        while (n - i > 4) {
            result.append(digits, i, i + 3).append('-');
            i += 3;
        }
        if (n - i == 4) {
            result.append(digits, i, i + 2).append('-').append(digits, i + 2, i + 4);
        } else {
            result.append(digits, i, n);
        }
        if (isTest) {
            System.out.println("--------------------------------\nresult: " + result.toString());
        }

        return result.toString();
    }
}