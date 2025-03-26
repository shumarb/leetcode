// Question: https://leetcode.com/problems/bulls-and-cows/description/

class BullsAndCows {
    public String getHint(String secret, String guess) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        int[] secretDigitFrequency = new int[10];
        int countBull = 0;
        int countCow = 0;

        // 1. Count bulls.
        for (int i = 0; i < guess.length(); i++) {
            int secretDigit = secret.charAt(i) - '0';
            int guessDigit = guess.charAt(i) - '0';

            if (secretDigit == guessDigit) {
                countBull++;
            } else {
                secretDigitFrequency[secretDigit]++;
            }
        }
        if (isTest) {
            System.out.println("countBull: " + countBull + "\nsecretDigitFrequency: " + Arrays.toString(secretDigitFrequency));
        }

        // 2. Count cows.
        for (int i = 0; i < secret.length(); i++) {
            int guessDigit = guess.charAt(i) - '0';
            int secretDigit = secret.charAt(i) - '0';
            if (secretDigit != guessDigit && secretDigitFrequency[guessDigit] > 0) {
                countCow++;
                secretDigitFrequency[guessDigit]--;
            }
        }

        result.append(countBull);
        result.append('A');
        result.append(countCow);
        result.append('B');
        if (isTest) {
            System.out.println("-----------------------------------");
            System.out.println("result: " + result.toString());
        }

        return result.toString();
    }
}