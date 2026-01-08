// Question: https://leetcode.com/problems/reverse-string-prefix/description/

class ReverseStringPrefix {
    public String reversePrefix(String s, int k) {
        if (s.length() == 1) {
            return s;
        }

        boolean isTest = false;
        char[] letters = s.toCharArray();
        int left = 0;
        int right = k - 1;

        if (isTest) {
            System.out.println("before, letters: " + Arrays.toString(letters));
        }
        while (left < right) {
            char temp = letters[left];
            letters[left++] = letters[right];
            letters[right--] = temp;
        }
        if (isTest) {
            System.out.println("after, letters: " + Arrays.toString(letters));
        }

        return new String(letters);
    }
}