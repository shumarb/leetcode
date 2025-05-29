// Question: https://leetcode.com/problems/longest-nice-substring/description/

class LongestNiceSubstring {
    public String longestNiceSubstring(String s) {
        String result = "";
        boolean isTest = false;

        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String str = s.substring(i, j + 1);
                if (isTest) {
                    System.out.println(" * check: " + str);
                }
                if (str.length() > result.length() && isNiceSubstring(str)) {
                    result = str;
                }
            }
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }

    private boolean isNiceSubstring(String word) {
        int[] frequency = new int[52];

        for (char letter: word.toCharArray()) {
            if (Character.isUpperCase(letter)) {
                frequency[letter - 'A']++;
            } else {
                frequency[letter - 'a' + 26]++;
            }
        }

        for (char letter: word.toCharArray()) {
            char complement;
            if (Character.isUpperCase(letter)) {
                complement = Character.toLowerCase(letter);
                if (frequency[complement - 'a' + 26] == 0) {
                    return false;
                }
            } else {
                complement = Character.toUpperCase(letter);
                if (frequency[complement - 'A'] == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}