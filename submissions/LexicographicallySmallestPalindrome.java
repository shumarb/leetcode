// Question: https://leetcode.com/problems/lexicographically-smallest-palindrome/description/

class LexicographicallySmallestPalindrome {
    public String makeSmallestPalindrome(String s) {
        boolean isTest = false;
        char[] palindrome = s.toCharArray();
        int left = 0;
        int len = s.length();
        int right = len - 1;

        if (isTest) {
            System.out.println("before, palindrome: " + Arrays.toString(palindrome));
        }
        while (left < right) {
            palindrome[left] = palindrome[right] = (char) Math.min(palindrome[left], palindrome[right]);
            left++;
            right--;
        }
        if (isTest) {
            System.out.println("after, palindrome: " + Arrays.toString(palindrome));
        }

        return new String(palindrome);
    }
}