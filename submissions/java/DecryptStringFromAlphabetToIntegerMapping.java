// Question: https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/description/

class DecryptStringFromAlphabetToIntegerMapping {
    public String freqAlphabets(String s) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        int i = s.length() - 1;

        while (i >= 0) {
            if (isTest) {
                System.out.println("------------------");
                System.out.println(" * i: " + i);
                System.out.println(" * before, result: " + result.toString());
            }

            if (i - 2 >= 0 && s.charAt(i) == '#') {
                int number = Integer.parseInt(s.substring(i - 2, i));
                result.append((char) ('a' + number - 1));
                i -= 3;
                if (isTest) {
                    System.out.println(" * found # at index " + i);
                    System.out.println(" * number: " + number);
                }
            } else {
                result.append((char) ('a' + s.charAt(i) - '1'));
                i--;
            }

            if (isTest) {
                System.out.println(" * after, result: " + result.toString());
            }
        }

        if (isTest) {
            System.out.println("------------------");
            System.out.println("s: " + s + ", result: " + result.toString());
        }

        return result.reverse().toString();
    }
}