// Question: https://leetcode.com/problems/lexicographically-smallest-string-after-a-swap/description/

class LexicographicallySmallestStringAfterASwap {
    public String getSmallestString(String s) {
        String result = s;
        boolean isTest = false;
        char[] digits = s.toCharArray();

        for (int i = 0; i < s.length() - 1; i++) {
            int current = s.charAt(i) - '0';
            int next = s.charAt(i + 1) - '0';

            if (current % 2 == next % 2 && s.charAt(i + 1) < s.charAt(i)) {
                if (isTest) {
                    System.out.println("-------------------------------------------------------");
                    System.out.println("indices: " + i + ", " + (i + 1));
                    System.out.println(" * before swap, digits: " + Arrays.toString(digits));
                }
                swap(digits, i, i + 1);
                if (isTest) {
                    System.out.println(" * after swap, digits: " + Arrays.toString(digits));
                }
                String newNumber = new String(digits);
                if (newNumber.compareTo(result) < 0) {
                    result = newNumber;
                }

                swap(digits, i, i + 1);
                if (isTest) {
                    System.out.println(" * restore digits | digits: " + Arrays.toString(digits));
                }
            }
        }

        return result;
    }

    private void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }
}