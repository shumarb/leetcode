// Question: https://leetcode.com/problems/reverse-degree-of-a-string/description/

class ReverseDegreeOfAString {
    public int reverseDegree(String s) {
        boolean isTest = false;
        int reverseDegree = 0;
        String key = "zyxwvutsrqponmlkjihgfedcba";

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            int letterIndex = letter - 'a';
            char letterKey = key.charAt(letterIndex);
            if (isTest) {
                System.out.println("------------------------------------------------------------------");
                System.out.println("s letter: " + letter + "\nletterKey: " + letterKey);
                System.out.println("before, reverseDegree: " + reverseDegree);
            }
            reverseDegree += ((i + 1) * (1 + letterKey - 'a'));
            if (isTest) {
                System.out.println("after, reverseDegree: " + reverseDegree);
            }
        }

        return reverseDegree;
    }
}