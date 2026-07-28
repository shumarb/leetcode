// Question: https://leetcode.com/problems/smallest-palindromic-rearrangement-i/description/

class SmallestPalindromicRearrangementI {
    public String smallestPalindrome(String s) {
        boolean isTest = false;
        int[] count = new int[26];
        int left = 0;
        int n = s.length();
        int right = n - 1;
        char[] result = new char[n];

        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }
        if (isTest) {
            System.out.println("count: " + Arrays.toString(count));
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }

            char letter = (char) ('a' + i);
            while (count[i] > 1) {
                result[left++] = letter;
                result[right--] = letter;
                count[i] -= 2;
            }
        }
        if (isTest) {
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("after first update, count: " + Arrays.toString(count) + "\nresult: " + Arrays.toString(result));
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                char letter = (char) ('a' + i);
                result[left++] = letter;
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
