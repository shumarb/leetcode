// Question: https://leetcode.com/problems/smallest-palindromic-rearrangement-i/description/

class SmallestPalindromicRearrangementI {
    public String smallestPalindrome(String s) {
        boolean isTest = false;
        char[] letters = s.toCharArray();
        char[] result = new char[letters.length];
        int[] count = new int[26];
        int firstIndex = 0;
        int n = letters.length;
        int lastIndex = n - 1;

        for (char c: letters) {
            count[c - 'a']++;
        }
        if (isTest) {
            System.out.println("letters: " + Arrays.toString(letters) + "\ncount: " + Arrays.toString(count));
        }

        for (int i = 0; i < count.length; i++) {
            while (count[i] > 1) {
                char letter = (char) ('a' + i);
                result[firstIndex++] = letter;
                result[lastIndex--] = letter;
                count[i] -= 2;
            }
        }
        if (isTest) {
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("after first update, count: " + Arrays.toString(count) + "\nresult: " + Arrays.toString(result));
        }

        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                char letter = (char) ('a' + i);
                result[firstIndex++] = letter;
                count[i]--;
            }
        }
        if (isTest) {
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("after second update, count: " + Arrays.toString(count) + "\nresult: " + Arrays.toString(result));
        }

        return new String(result);
    }
}
