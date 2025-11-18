// Question: https://leetcode.com/problems/greatest-common-divisor-of-strings/description/

class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        boolean isTest = false;
        int i = 0;
        int j = 0;

        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                break;
            }
        }
        if (isTest) {
            System.out.println("i: " + i + "\nj: " + j);
        }

        if (i == 0 && j == 0) {
            return "";
        }

        return i == str1.length() ? str2.substring(j, str2.length()) : str1.substring(i, str1.length());
    }
}