// Question: https://leetcode.com/problems/shortest-completing-word/description/

class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String result = null;
        boolean isTest = false;
        int[] licensePlateLetterFrequency = getLetterFrequency(licensePlate);

        if (isTest) {
            System.out.println("licencePlate: " + licensePlate + "\nwords: " + Arrays.toString(words));
            System.out.println("licensePlateLetterFrequency: " + Arrays.toString(licensePlateLetterFrequency));
        }

        for (String word: words) {
            int[] wordLetterFrequency = getLetterFrequency(word);
            if (isTest) {
                System.out.println("----------------------------------------------------------------------------------------------------");
                System.out.println(" * comparing | licensePlate: " + licensePlate + " | word: " + word);
                System.out.println(" * licensePlateLetterFrequency: " + Arrays.toString(licensePlateLetterFrequency));
                System.out.println(" * wordLetterFrequency: " + Arrays.toString(wordLetterFrequency));
            }
            if (isShortestCompletingWord(licensePlateLetterFrequency, wordLetterFrequency)) {
                if (result == null) {
                    result = word;
                } else if (result != null && word.length() < result.length()) {
                    result = word;
                }
            }
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }

    private boolean isShortestCompletingWord(int[] first, int[] second) {
        for (int i = 0; i < first.length; i++) {
            if (first[i] > 0 && second[i] == 0) {
                return false;
            } else if (first[i] > 0 && second[i] > 0 && second[i] < first[i]) {
                return false;
            }
        }

        return true;
    }

    private int[] getLetterFrequency(String word) {
        int[] letterFrequency = new int[26];
        for (char c: word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                letterFrequency[Character.toLowerCase(c) - 'a']++;
            } else if (Character.isLowerCase(c)) {
                letterFrequency[c - 'a']++;
            }
        }

        return letterFrequency;
    }
}