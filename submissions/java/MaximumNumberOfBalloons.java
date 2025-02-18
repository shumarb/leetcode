// Question: https://leetcode.com/problems/maximum-number-of-balloons/description/

class MaximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] letterFrequency = new int[26];
        int maximumCount = 0;
        boolean isTest = false;

        for (char letter: text.toCharArray()) {
            if (isValid(letter)) {
                letterFrequency[letter - 'a']++;
            }
        }
        if (isTest) {
            System.out.println("text: " + text + "\nletterFrequency: " + Arrays.toString(letterFrequency));
        }

        return countMaximum(letterFrequency);
    }

    private int countMaximum(int[] letterFrequency) {
        int count = Integer.MAX_VALUE;
        count = Math.min(count, letterFrequency['b' - 'a']);
        count = Math.min(count, letterFrequency['a' - 'a']);
        count = Math.min(count, letterFrequency['l' - 'a'] / 2);
        count = Math.min(count, letterFrequency['o' - 'a'] / 2);
        count = Math.min(count, letterFrequency['n' - 'a']);
        return count;
    }

    private boolean isValid(char letter) {
        return letter == 'b' || letter == 'a' || letter == 'l' || letter == 'o' || letter == 'n';
    }
}