// Question: https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/description/

class FindResultantArraysAfterRemovingAnagrams {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        boolean isTest = false;

        // 1. Set first word as anagram to be removed.
        result.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (!isAnagram(words[i - 1], words[i])) {
                result.add(words[i]);
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------");
            System.out.println("result: " + result);
        }

        return result;
    }

    private boolean isAnagram(String first, String second) {
        int[] frequency = new int[26];
        for (char letter: first.toCharArray()) {
            frequency[letter - 'a']++;
        }
        for (char letter: second.toCharArray()) {
            frequency[letter - 'a']--;
        }
        for (int letterFrequency: frequency) {
            if (letterFrequency != 0) {
                return false;
            }
        }
        return true;
    }
}