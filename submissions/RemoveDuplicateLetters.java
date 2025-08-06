// Question: https://leetcode.com/problems/remove-duplicate-letters/description/

class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        boolean isTest = false;
        boolean[] isLetterInStack = new boolean[26];
        char[] letters;
        int[] frequency = new int[26];

        for (char letter: s.toCharArray()) {
            frequency[letter - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);

            /**
             1.  Reduce frequency to ensure less letters to be compared
                 in future checks.
             */
            if (isLetterInStack[letter - 'a']) {
                frequency[letter - 'a']--;
                continue;
            }

            /**
             2.  If top element is lexicographically larger than letter
                 and frequency of top element is more than 0,
                 remove top element to form smallest lexicographically order.
                 Eg: bc; incoming a, and c has frequency > 0,
                 smallest lexicographical string could be ba, followed by c from remaining frequency.
             */
            while (!stack.isEmpty() && stack.peek() > letter && frequency[stack.peek() - 'a'] > 0) {
                char remove = stack.pop();
                isLetterInStack[remove - 'a'] = false;
            }

            stack.push(letter);
            frequency[letter - 'a']--;
            isLetterInStack[letter - 'a'] = true;
        }
        if (isTest) {
            System.out.println("s: " + s + "\nstack: " + stack);
        }

        letters = new char[stack.size()];
        int j = stack.size() - 1;
        while (!stack.isEmpty()) {
            letters[j--] = stack.pop();
        }

        return new String(letters);
    }
}