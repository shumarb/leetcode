// Question: https://leetcode.com/problems/find-common-characters/description/

class FindCommonCharacters {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        int[][] letterFrequency = new int[words.length][26];
        boolean isTest = false;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            letterFrequency[i] = countLetters(word);
        }
        if (isTest) {
            System.out.println("words: " + Arrays.toString(words));
            System.out.println("letterFrequency:");
            for (int[] row: letterFrequency) {
                System.out.println(Arrays.toString(row));
            }
        }

        for (int i = 0; i < 26; i++) {
            int count = letterFrequency[0][i];
            if (count > 0) {
                String letter = Character.toString((char) ('a' + i));
                boolean isLetterPresent = true;
                if (isTest) {
                    System.out.println(" * check | " + letter + ", count: " + count);
                }
                for (int j = 1; j < letterFrequency.length; j++) {
                    // 1. End check if letter is not present in >= 1 other word.
                    if (letterFrequency[j][i] == 0) {
                        isLetterPresent = false;
                        break;
                    } else {
                        /**
                         2.  Letter is present in another word,
                         so find minimum count of letter in words.
                         */
                        count = Math.min(count, letterFrequency[j][i]);
                    }
                }
                if (isLetterPresent) {
                    for (int k = 0; k < count; k++) {
                        result.add(letter);
                    }
                }
            }
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }

    private int[] countLetters(String word) {
        int[] letterFrequency = new int[26];
        for (char letter: word.toCharArray()) {
            letterFrequency[letter - 'a']++;
        }
        return letterFrequency;
    }
}