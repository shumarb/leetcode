// Question: https://leetcode.com/problems/reverse-string/description/

class ReverseString {
    public void reverseString(char[] s) {
        if (s.length > 1) {
            int left = 0;
            int right = s.length - 1;
            while (left < right) {
                char temp = s[left];
                s[left++] = s[right];
                s[right--] = temp;
            }
        }
    }
}