// Question: https://leetcode.com/problems/longest-nice-substring/description/

class LongestNiceSubstring {
    public String longestNiceSubstring(String s) {
        String result = "";
        boolean isTest = false;

        if (isTest) {
            System.out.println("s: " + s + "\n------------------------");
        }
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String str = s.substring(i, j + 1);
                int n = str.length();

                if (n >= 2 && n > result.length() && isNiceSubstring(str)) {
                    if (isTest) {
                        System.out.println(" * indices: [" + i + ", " + j + "] | substring: " + str);
                    }

                    result = str;
                }
            }
        }
        if (isTest) {
            System.out.println("------------------------\nresult: " + result);
        }

        return result;
    }

    private boolean isNiceSubstring(String word) {
        boolean[] isPresent = new boolean[52];

        for (char letter: word.toCharArray()) {
            if (Character.isUpperCase(letter)) {
                isPresent[letter - 'A'] = true;
            } else {
                isPresent[letter - 'a' + 26] = true;
            }
        }

        for (char letter: word.toCharArray()) {
            char lower = Character.toLowerCase(letter);
            char upper = Character.toUpperCase(letter);

            if (!isPresent[lower - 'a' + 26] || !isPresent[upper - 'A']) {
                return false;
            }
        }

        return true;
    }
}
