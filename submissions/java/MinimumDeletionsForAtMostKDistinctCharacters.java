// Question: https://leetcode.com/problems/minimum-deletions-for-at-most-k-distinct-characters/description/

class MinimumDeletionsForAtMostKDistinctCharacters {
    public int minDeletion(String s, int k) {
        List<int[]> list = new ArrayList<>();
        boolean isTest = false;
        int countDistinctLetters = 0;
        int minDeletion = 0;
        int[] letterFrequency = new int[26];

        for (char letter: s.toCharArray()) {
            if (letterFrequency[letter - 'a'] == 0) {
                countDistinctLetters++;
            }
            letterFrequency[letter - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (letterFrequency[i] > 0) {
                list.add(new int[] {i, letterFrequency[i]});
            }
        }
        list.sort((a, b) -> Integer.compare(a[1], b[1]));
        if (isTest) {
            System.out.println("s: " + s + "\nk: " + k);
            System.out.println("letterFrequency: " + Arrays.toString(letterFrequency) + "\ncountDistinctLetters: " + countDistinctLetters);
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("list:");
            for (int[] entry: list) {
                System.out.println(" * " + (char) (entry[0] + 'a') + " --> " + entry[1]);
            }
            System.out.println("--------------------------------------------------------------------------------------");
        }

        // 1. No deletions required, so return 0.
        if (countDistinctLetters <= k) {
            return 0;
        }

        /**
         2.  Select a character with least frequency,
             increase count by this letter's frequency number of deletions,
             and repeat until number of distinct characters == k.
         */
        int i = 0;
        while (countDistinctLetters > k) {
            if (isTest) {
                System.out.println("before | countDistinctLetters: " + countDistinctLetters + ", minDeletion: " + minDeletion);
                System.out.println(" * remove: " + (char) ('a' + list.get(i)[0]) + " --> frequency: " + list.get(i)[1]);
            }
            minDeletion += list.get(i++)[1];
            countDistinctLetters--;
            if (isTest) {
                System.out.println("after | countDistinctLetters: " + countDistinctLetters + ", minDeletion: " + minDeletion);
                System.out.println("--------------------------------------------------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("minDeletion: " + minDeletion);
        }

        return minDeletion;
    }
}