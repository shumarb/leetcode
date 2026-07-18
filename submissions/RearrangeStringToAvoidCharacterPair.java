// Question: https://leetcode.com/problems/rearrange-string-to-avoid-character-pair/description/

class RearrangeStringToAvoidCharacterPair {
    public String rearrangeString(String s, char x, char y) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        int[] count = new int[26];

        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < count[y - 'a']; i++) {
            result.append(y);
        }
        for (int i = 0; i < count[x - 'a']; i++) {
            result.append(x);
        }
        if (isTest) {
            System.out.println("s: " + s + "\ncount: " + Arrays.toString(count) + "\nresult so far: " + result);
        }

        for (int i = 0; i < 26; i++) {
            char letter = (char) ('a' + i);
            if (letter == x || letter == y) {
                continue;
            }

            if (count[letter - 'a'] > 0) {
                if (isTest) {
                    System.out.println(" * add: " + letter);
                }

                int total = count[letter - 'a'];
                while (total-- > 0) {
                    result.append(letter);
                }
            }
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result.toString();
    }
}
