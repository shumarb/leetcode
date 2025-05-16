// Question: https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/description/

class FindMostFrequentVowelAndConsonant {
    public int maxFreqSum(String s) {
        boolean isTest = false;
        int maximumConsonantFrequency = 0;
        int maximumVowelFrequency = 0;
        int[] letterFrequency = new int[26];

        for (char letter: s.toCharArray()) {
            letterFrequency[letter - 'a']++;
            if (isVowel(letter)) {
                maximumVowelFrequency = Math.max(maximumVowelFrequency, letterFrequency[letter - 'a']);
            } else {
                maximumConsonantFrequency = Math.max(maximumConsonantFrequency, letterFrequency[letter - 'a']);
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\nletterFrequency: " + Arrays.toString(letterFrequency));
            System.out.println("maximumVowelFrequency: " + maximumVowelFrequency + "\nmaximumConsonantFrequency: " + maximumConsonantFrequency);
        }

        return maximumConsonantFrequency + maximumVowelFrequency;
    }

    private boolean isVowel(char letter) {
        return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u';
    }
}