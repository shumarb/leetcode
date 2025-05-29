// Question: https://leetcode.com/problems/longest-nice-substring/description/

class LongestNiceSubstring {
    public String longestNiceSubstring(String s) {
        String result = "";
        boolean isTest = false;

        for (int i = 0; i < s.length() - 1; i++) {
            StringBuilder current = new StringBuilder();
            current.append(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                current.append(s.charAt(j));
                if (isTest) {
                    System.out.println(" * check: " + current.toString());
                }
                if (current.toString().length() > result.length() && isNiceSubstring(current.toString())) {
                    result = current.toString();
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