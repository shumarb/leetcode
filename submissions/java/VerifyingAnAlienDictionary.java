// Question: https://leetcode.com/problems/verifying-an-alien-dictionary/description/

class VerifyingAnAlienDictionary {
    private boolean isTest = false;

    public boolean isAlienSorted(String[] words, String order) {
        int i = 1;
        int[] orderLettersPosition = new int[26];

        for (char letter: order.toCharArray()) {
            orderLettersPosition[letter - 'a'] = i++;
        }
        if (isTest) {
            System.out.println("words: " + Arrays.toString(words) + "\norder: " + order );
            System.out.println("\norderLettersPosition: " + Arrays.toString(orderLettersPosition));
            System.out.println("-----------------------------------------------------------------------------");
        }

        for (i = 1; i < words.length; i++) {
            if (!isSortedLexicographically(words[i - 1], words[i], orderLettersPosition)) {
                return false;
            }
        }

        return true;
    }

    private boolean isSortedLexicographically(String first, String second, int[] orderLettersPosition) {
        if (isTest) {
            System.out.println("comparing | first: " + first + ", second: " + second);
        }

        int i = 0;
        while (i < first.length() && i < second.length()) {
            char firstLetter = first.charAt(i);
            char secondLetter = second.charAt(i);
            if (isTest) {
                System.out.println(" * firstLetter: " + firstLetter + " --> " + orderLettersPosition[firstLetter - 'a']);
                System.out.println(" * secondLetter: " + secondLetter + " --> " + orderLettersPosition[secondLetter - 'a']);
                System.out.println("-----------------------------------------------------------------------------");
            }

            if (firstLetter != secondLetter) {
                return orderLettersPosition[firstLetter - 'a'] < orderLettersPosition[secondLetter - 'a'];
            }

            i++;
        }

        /**
         1.  Both words are either the same, or one word is prefix of another.
             If second word is equal to or longer than first word,
             then both words are arranged in lexicographically-ascending order.
         */
        return first.length() <= second.length();
    }
}