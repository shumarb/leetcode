// Question: https://leetcode.com/problems/reverse-string-ii/description/

class ReverseStringTwo {
    public String reverseStr(String s, int k) {
        boolean isTest = false;
        char[] letters = s.toCharArray();
        int length = s.length();

        if (isTest) {
            System.out.println("before, letters: " + Arrays.toString(letters));
            System.out.println("---------------------------------------------------------------------------------");
        }
        for (int i = 0; i < length; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, length - 1);
            if (isTest) {
                System.out.println(" * block | left: " + left + ", right: " + right);
                System.out.println(" ** before, letters: " + Arrays.toString(letters));
            }
            while (left < right) {
                char temp = letters[left];
                letters[left++] = letters[right];
                letters[right--] = temp;
            }
            if (isTest) {
                System.out.println(" ** after, letters: " + Arrays.toString(letters));
                System.out.println("---------------------------------------------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("after, letters: " + Arrays.toString(letters));
            System.out.println("result: " + new String(letters));
        }

        return new String(letters);
    }
}