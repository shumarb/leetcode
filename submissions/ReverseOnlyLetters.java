// Question: https://leetcode.com/problems/reverse-only-letters/description/

class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        char[] letters = s.toCharArray();
        int left = 0;
        int right = letters.length - 1;

        while (left < right) {
            while (left < right && !Character.isLetter(letters[left])) {
                left++;
            }
            while (left < right && !Character.isLetter(letters[right])) {
                right--;
            }
            char temp = letters[left];
            letters[left++] = letters[right];
            letters[right--] = temp;
        }

        return new String(letters);
    }
}