// Question: https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/description/

class MininumNumberOfPushesToTypeWordII {
    public int minimumPushes(String word) {
        int[] count = new int[26];
        int countPresses = 1;
        int countUniqueLettersInGroup = 0;
        int result = 0;

        for (char c: word.toCharArray()) {
            count[c - 'a']++;
        }
        Arrays.sort(count);
        for (int i = 25; i >= 0; i--) {
            if (count[i] == 0) {
                break;
            }

            result += count[i] * countPresses;
            if (++countUniqueLettersInGroup == 8) {
                countPresses++;
                countUniqueLettersInGroup = 0;
            }
        }

        return result;
    }
}
