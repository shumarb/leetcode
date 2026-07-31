// Question: https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/description/

class MininumNumberOfPushesToTypeWordI {
    public int minimumPushes(String word) {
        boolean isTest = false;
        int countLettersPerGroup = 0;
        int countPresses = 1;
        int result = 0;

        for (char letter: word.toCharArray()) {
            if (isTest) {
                System.out.println(" * letter: " + letter + " -> " + countPresses + " presses");
            }

            result += countPresses;
            if (++countLettersPerGroup == 8) {
                countLettersPerGroup = 0;
                countPresses++;
            }
        }
        if (isTest) {
            System.out.println("-------------------------\nresult: " + result);
        }

        return result;
    }
}
