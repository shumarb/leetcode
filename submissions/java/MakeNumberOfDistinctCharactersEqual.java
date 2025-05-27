// Question: https://leetcode.com/problems/make-number-of-distinct-characters-equal/description/

class MakeNumberOfDistinctCharactersEqual {
    public boolean isItPossible(String word1, String word2) {
        boolean isTest = false;
        int[] firstFrequency = new int[26];
        int[] secondFrequency = new int[26];

        for (char letter: word1.toCharArray()) {
            firstFrequency[letter - 'a']++;
        }
        for (char letter: word2.toCharArray()) {
            secondFrequency[letter - 'a']++;
        }
        if (isTest) {
            System.out.println("word1: " + word1 + "\nword2: " + word2);
            System.out.println("word1: " + Arrays.toString(firstFrequency));
            System.out.println("word2: " + Arrays.toString(secondFrequency));
        }

        for (int i = 0; i < 26; i++) {
            if (firstFrequency[i] == 0) {
                continue;
            }
            for (int j = 0; j < 26; j++) {
                if (secondFrequency[j] == 0) {
                    continue;
                }
                int[] f1 = firstFrequency.clone();
                int[] f2 = secondFrequency.clone();
                if (f1[i] > 0 && f2[j] > 0) {
                    f1[i]--;
                    f1[j]++;
                    f2[j]--;
                    f2[i]++;
                    if (countDistinct(f1) == countDistinct(f2)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private int countDistinct(int[] frequency) {
        int count = 0;
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                count++;
            }
        }
        return count;
    }
}