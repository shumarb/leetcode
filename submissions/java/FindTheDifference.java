// Question: https://leetcode.com/problems/find-the-difference/description/

class FindTheDifference {
    public char findTheDifference(String s, String t) {
        boolean isTest = false;
        int charIntValue = 0;

        for (char letter: t.toCharArray()) {
            charIntValue += letter;
        }
        if (isTest) {
            System.out.println("1. charIntValue: " + charIntValue);
        }

        for (char letter: s.toCharArray()) {
            charIntValue -= letter;
        }
        if (isTest) {
            System.out.println("2. charIntValue: " + charIntValue);
        }

        return (char) charIntValue;
    }
}