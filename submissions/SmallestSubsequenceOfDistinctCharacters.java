// Question: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/description/

class SmallestSubsequenceOfDistinctCharacters {
    public String smallestSubsequence(String s) {
        // 1. Edge case: String has only 1 character.
        if (s.length() == 1) {
            return s;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] isLetterInStack = new boolean[26];
        boolean isTest = false;
        char[] letters = s.toCharArray();
        char[] result;
        int[] frequency = new int[26];

        for (char letter: s.toCharArray()) {
            frequency[letter - 'a']++;
        }

        for (char letter: letters) {
            if (isLetterInStack[letter - 'a']) {
                frequency[letter - 'a']--;
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > letter && frequency[stack.peek() - 'a'] > 0) {
                isLetterInStack[stack.pop() - 'a'] = false;
            }

            stack.push(letter);
            frequency[letter - 'a']--;
            isLetterInStack[letter - 'a'] = true;
        }
        if (isTest) {
            System.out.println("s: " + stack + "\nstack: " + stack);
        }

        result = new char[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            result[i--] = stack.pop();
        }

        return new String(result);
    }
}
