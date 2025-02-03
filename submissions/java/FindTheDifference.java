// Question: https://leetcode.com/problems/find-the-difference/description/

class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        boolean isTest = false;
        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char x: t.toCharArray()) {
            count[x - 'a']--;
            if (count[x - 'a'] < 0) {
                return x;
            }
        }
        if (isTest) {
            System.out.println("count: " + Arrays.toString(count));
        }
        return 'a'; // dummmy value won't be reached
    }
}