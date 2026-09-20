// Question: https://leetcode.com/problems/reverse-degree-of-a-string/description/

class ReverseDegreeOfAString {
    public int reverseDegree(String s) {
        boolean isTest = false;
        char[] letters = s.toCharArray();
        int[] score = new int[26];
        int n = score.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            score[i] = n - i;
        }
        if (isTest) {
            System.out.println("letters: " + Arrays.toString(letters) + "\nscore: " + Arrays.toString(score));
            System.out.println("-------------------------------------------------------------------------------------------------");
        }

        for (int i = 0; i < letters.length; i++) {
            char letter = letters[i];
            int value = score[letter - 'a'];
            int product = (i + 1) * value;

            if (isTest) {
                System.out.println(" * letter: " + letter + ", value: " + value + ", index: " + (i + 1) + " -> product: " + product);
            }

            result += product;
        }
        if (isTest) {
            System.out.println("-------------------------------------------------------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
