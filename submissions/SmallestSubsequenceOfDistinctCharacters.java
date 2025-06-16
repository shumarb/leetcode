// Question: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/description/

class SmallestSubsequenceOfDistinctCharacters {
    public String smallestSubsequence(String s) {
        StringBuilder stack = new StringBuilder();
        boolean[] inStack = new boolean[26];
        int[] lastIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            int index = letter - 'a';
            if (inStack[index]) {
                continue;
            }

            while (stack.length() > 0
                    && letter < stack.charAt(stack.length() - 1)
                    && lastIndex[stack.charAt(stack.length() - 1) - 'a'] > i) {
                inStack[stack.charAt(stack.length() - 1) - 'a'] = false;
                stack.deleteCharAt(stack.length() - 1);
            }

            stack.append(letter);
            inStack[index] = true;
        }

        return stack.toString();
    }
}