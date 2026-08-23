// Question: https://leetcode.com/problems/check-ascii-palindromic/description/

class CheckAsciiPalindromic {
    public boolean isPalindromic(String s) {
        StringBuilder key = new StringBuilder();
        String[] map = new String[26];
        boolean isTest = false;
        char[] bits;
        int left = 0;
        int right;

        if (isTest) {
            System.out.println("s: " + s + "\n------------------------------------------------------------------------");
        }
        for (char letter: s.toCharArray()) {
            int index = letter - 'a';
            if (map[index] == null) {
                map[index] = String.format("%8s", Integer.toBinaryString((int) letter)).replace(' ', '0');
            }
            if (isTest) {
                System.out.println(" * letter: " + letter + " -> value: " + ((int) letter) + " -> binary: " + map[index]);
            }
            key.append(map[index]);
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
