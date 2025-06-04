// Question: https://leetcode.com/problems/maximum-number-of-balloons/description/

class MaximumNumberOfBalloon {
    public int maxNumberOfBalloons(String text) {
        String word = "balloon";
        boolean isTest = false;
        int count = Integer.MAX_VALUE;
        int[] textFrequency = new int[26];
        int[] wordFrequency = new int[26];

        for (char letter: text.toCharArray()) {
            textFrequency[letter - 'a']++;
        }
        for (char letter: word.toCharArray()) {
            wordFrequency[letter - 'a']++;
        }
        /**
         1.  Divide frequency by 2 for letters 'l' and 'o'
         as these letters are counted as a pair.
         */
        wordFrequency['l' - 'a'] /= 2;
        wordFrequency['o' - 'a'] /= 2;
        textFrequency['l' - 'a'] /= 2;
        textFrequency['o' - 'a'] /= 2;
        if (isTest) {
            System.out.println("text: " + text + "\nword: " + word);
            System.out.println("textFrequency: " + Arrays.toString(textFrequency));
            System.out.println("wordFrequency: " + Arrays.toString(wordFrequency));
        }

        for (char letter: word.toCharArray()) {
            // 2. Can't form "balloon" if text has insufficient letters.
            if (textFrequency[letter - 'a'] == 0 || textFrequency[letter - 'a'] < wordFrequency[letter - 'a']) {
                return 0;
            } else {
                count = Math.min(count, textFrequency[letter - 'a'] / wordFrequency[letter - 'a']);
            }
        }
        if (isTest) {
            System.out.println("count: " + count);
        }

        return count;
    }
}