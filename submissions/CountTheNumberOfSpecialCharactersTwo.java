// Question: https://leetcode.com/problems/count-the-number-of-special-characters-ii/description/

class CountTheNumberOfSpecialCharactersTwo {
    public int numberOfSpecialChars(String word) {
        boolean isTest = false;
        int[] firstUpper = new int[26];
        int[] lastLower = new int[26];
        int result = 0;

        Arrays.fill(firstUpper, -1);
        Arrays.fill(lastLower, -1);
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (letter >= 'a' && letter <= 'z') {
                lastLower[letter - 'a'] = i;

            } else {
                if (firstUpper[letter - 'A'] == -1) {
                    firstUpper[letter - 'A'] = i;
                }
            }
        }
        if (isTest) {
            System.out.println("word: " + word + "\nfirstUpper: " + Arrays.toString(firstUpper));
            System.out.println("lastLower: " + Arrays.toString(lastLower));
        }
        for (int i = 0; i < 26; i++) {
            if (firstUpper[i] != -1 && lastLower[i] != -1 && firstUpper[i] > lastLower[i]) {
                if (isTest) {
                    System.out.println(" * valid: " + (char) ('a' + i));
                }
                result++;
            }
        }

        return result;
    }
}
