// Question: https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/description/

class MaximumDifferenceBetweenEvenAndOddFrequencyOne {
    public int maxDifference(String s) {
        int maxDifference = 0;
        int countMaxOddOccurrences = Integer.MIN_VALUE;
        int countMinEvenOccurrences = Integer.MAX_VALUE;
        int[] letterFrequency = new int[26];
        boolean isTest = false;

        for (char letter: s.toCharArray()) {
            int index = letter - 'a';
            letterFrequency[index]++;
        }

        for (int element: letterFrequency) {
            if (element > 0 && element % 2 == 0) {
                countMinEvenOccurrences = Math.min(countMinEvenOccurrences, element);
            } else if (element > 0 && element % 2 != 0) {
                countMaxOddOccurrences = Math.max(countMaxOddOccurrences, element);
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\nletterFrequency: " + Arrays.toString(letterFrequency));
            System.out.println("countMaxOddOccurrences: " + countMaxOddOccurrences + ", countMinEvenOccurrences: " + countMinEvenOccurrences);
        }

        return countMaxOddOccurrences - countMinEvenOccurrences;
    }
}