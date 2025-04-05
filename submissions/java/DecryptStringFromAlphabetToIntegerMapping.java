// Question: https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/description/

class DecryptStringFromAlphabetToIntegerMapping {
    public String freqAlphabets(String s) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        int i = 0;

        while (i < s.length()) {
            if (isTest) {
                System.out.println("i: " + i + "\nbefore | result: " + result.toString());
            }
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                int number = Integer.parseInt(s.substring(i, i + 2));
                result.append((char) ('a' + number - 1));
                i += 3;
            } else {
                result.append((char) ('a' + s.charAt(i) - '1'));
                i++;
            }
            if (isTest) {
                System.out.println("after | result: " + result.toString());
                System.out.println("------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("s: " + s + ", result: " + result.toString());
        }

        return result.toString();
    }
}