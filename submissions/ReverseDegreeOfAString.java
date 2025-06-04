// Question: https://leetcode.com/problems/reverse-degree-of-a-string/description/

class ReverseDegreeOfAString {
    public int reverseDegree(String s) {
        String key = "zyxwvutsrqponmlkjihgfedcba";
        boolean isTest = false;
        int reverseDegree = 0;

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            int letterValue = letter - 'a';
            char letterKey = key.charAt(letterValue);
            if (isTest) {
                System.out.println("------------------------------------------------------------------");
                System.out.println("s letter: " + letter + "\nletterValue: " + letterValue);
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