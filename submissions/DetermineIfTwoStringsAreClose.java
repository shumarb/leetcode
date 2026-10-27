// Question: https://leetcode.com/problems/determine-if-two-strings-are-close/description/

class DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;

        } else if (word1.equals(word2)) {
            return true;
        }

        boolean isTest = false;
        int n = word1.length();
        int[] count1 = count(word1);
        int[] count2 = count(word2);
        int[] countFrequency1 = countFrequency(count1, n);
        int[] countFrequency2 = countFrequency(count2, n);

        for (int i = 0; i < count1.length; i++) {
            if ((count1[i] == 0 && count2[i] > 0) || (count2[i] == 0 && count1[i] > 0)) {
                return false;
            }
        }
        if (isTest) {
            System.out.println("word1: " + word1 + "\ncount1: " + Arrays.toString(count1) + "\ncountFrequency1: " + Arrays.toString(countFrequency1));
            System.out.println("\nword2: " + word2 + "\ncount2: " + Arrays.toString(count2) + "\ncountFrequency2: " + Arrays.toString(countFrequency2));
        }

        return Arrays.equals(countFrequency1, countFrequency2);
    }

    private int[] countFrequency(int[] count, int n) {
        int[] result = new int[n + 1];

        for (int i = 0; i < count.length; i++) {
            int frequency = count[i];

            if (frequency == 0) {
                continue;
            }

            result[frequency]++;
        }

        return result;
    }

    private int[] count(String word) {
        int[] result = new int[26];

        for (char c: word.toCharArray()) {
            result[c - 'a']++;
        }

        return result;
    }
}
