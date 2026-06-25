// Question: https://leetcode.com/problems/reverse-vowels-of-a-string/description/

class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        boolean isTest = false;
        char[] letters = s.toCharArray();
        int left = 0;
        int n = letters.length;
        int right = n - 1;

        if (n == 1) {
            return s;
        }

        if (isTest) {
            System.out.println("before: " + Arrays.toString(letters));
            System.out.println("----------------------------");
        }

        while (left < right) {
            while (left < n && left < right && !isVowel(letters[left])) {
                left++;
            }

            while (right >= 0 && left < right && !isVowel(letters[right])) {
                right--;
            }

            if (isTest) {
                System.out.println(" * left: " + left + ", right: " + right);
            }

            if (left < n && right >= 0 && left < right) {
                char temp = letters[left];
                letters[left] = letters[right];
                letters[right] = temp;
            }

            left++;
            right--;
        }

        if (isTest) {
            System.out.println("----------------------------\nafter:  " + Arrays.toString(letters));
        }

        return new String(letters);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
