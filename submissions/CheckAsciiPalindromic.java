// Question: https://leetcode.com/problems/check-ascii-palindromic/description/

class CheckAsciiPalindromic {
    public boolean isPalindromic(String s) {
        StringBuilder key = new StringBuilder();
        boolean isTest = false;
        char[] bits;
        int left = 0;
        int right;

        if (isTest) {
            System.out.println("s: " + s + "\n------------------------------------------------------------------------");
        }
        for (char letter: s.toCharArray()) {
            String binary = String.format("%8s", Integer.toBinaryString((int) letter)).replace(' ', '0');
            if (isTest) {
                System.out.println(" * letter: " + letter + " -> value: " + ((int) letter) + " -> binary: " + binary);
            }
            key.append(binary);
        }
        if (isTest) {
            System.out.println("------------------------------------------------------------------------\nkey: " + key);
        }

        right = key.length() - 1;
        while (left < right) {
            if (key.charAt(left++) != key.charAt(right--)) {
                return false;
            }
        }

        return true;
    }
}
