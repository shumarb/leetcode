// Question: https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars/description/

class LexicographicallyMinimumStringAfterRemovingStars {
    public String clearStars(String s) {
        Stack<Integer>[] lastIndex = (Stack<Integer>[]) new Stack[26];
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        char[] parts = s.toCharArray();

        if (isTest) {
            System.out.println("s: " + s + "\nparts: " + Arrays.toString(parts));
        }
        for (int i = 0; i < 26; i++) {
            lastIndex[i] = new Stack<>();
        }
        for (int i = 0; i < parts.length; i++) {
            char current = parts[i];
            if (current != '*') {
                lastIndex[current - 'a'].push(i);
            } else {
                for (int j = 0; j < 26; j++) {
                    if (!lastIndex[j].isEmpty()) {
                        parts[lastIndex[j].pop()] = '*';
                        break;
                    }
                }
            }
        }
        for (char letter: parts) {
            if (letter != '*') {
                result.append(letter);
            }
        }
        if (isTest) {
            System.out.println("\nparts: " + Arrays.toString(parts) + "\nresult: " + result.toString());
        }

        return result.toString();
    }
}