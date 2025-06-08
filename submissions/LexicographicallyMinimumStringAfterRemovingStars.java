// Question: https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars/description/

class LexicographicallyMinimumStringAfterRemovingStars {
    public String clearStars(String s) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        char[] parts = s.toCharArray();
        List<Stack<Integer>> lastIndex = new ArrayList<>();

        if (isTest) {
            System.out.println("s: " + s + "\nparts: " + Arrays.toString(parts));
        }
        for (int i = 0; i < 26; i++) {
            lastIndex.add(new Stack<>());
        }
        for (int i = 0; i < parts.length; i++) {
            char current = parts[i];
            if (current != '*') {
                lastIndex.get(current - 'a').push(i);
            } else {
                for (int j = 0; j < 26; j++) {
                    if (!lastIndex.get(j).isEmpty()) {
                        int indexOfUpdate = lastIndex.get(j).pop();
                        parts[indexOfUpdate] = '*';
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