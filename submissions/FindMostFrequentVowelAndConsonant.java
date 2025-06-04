// Question: https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/description/

class FindMostFrequentVowelAndConsonant {
    public int maxFreqSum(String s) {
        String vowels = "aeiou";
        boolean isTest = false;
        int maximumConsonantFrequency = 0;
        int maximumVowelFrequency = 0;
        int[] letterFrequency = new int[26];

        for (char letter: s.toCharArray()) {
            letterFrequency[letter - 'a']++;
            if (vowels.indexOf(letter) == -1) {
                maximumConsonantFrequency = Math.max(maximumConsonantFrequency, letterFrequency[letter - 'a']);
            } else {
                maximumVowelFrequency = Math.max(maximumVowelFrequency, letterFrequency[letter - 'a']);
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\nletterFrequency: " + Arrays.toString(letterFrequency));
            System.out.println("maximumVowelFrequency: " + maximumVowelFrequency + "\nmaximumConsonantFrequency: " + maximumConsonantFrequency);
        }

        return maximumConsonantFrequency + maximumVowelFrequency;
    }
}