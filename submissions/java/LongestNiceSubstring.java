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
                if (isNiceSubstring(current.toString()) && current.toString().length() > result.length()) {
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
        Set<Character> lower = new HashSet<>();
        Set<Character> upper = new HashSet<>();

        for (char letter: word.toCharArray()) {
            if (Character.isUpperCase(letter)) {
                upper.add(letter);
            } else {
                lower.add(letter);
            }
        }
        for (char letter: word.toCharArray()) {
            if (Character.isUpperCase(letter) && !lower.contains(Character.toLowerCase(letter))) {
                return false;
            }
            if (Character.isLowerCase(letter) && !upper.contains(Character.toUpperCase(letter))) {
                return false;
            }
        }

        return true;
    }
}