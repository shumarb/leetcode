// Question: https://leetcode.com/problems/check-ascii-palindromic/description/

class CheckAsciiPalindromic {
    public boolean isPalindromic(String s) {
        StringBuilder key = new StringBuilder();
        String[] map = new String[26];
        boolean isTest = false;
        int left = 0;
        int right;

        if (isTest) {
            System.out.println("s: " + s + "\n------------------------------------------------------------------------");
        }
        for (char letter: s.toCharArray()) {
            int index = letter - 'a';
            int value = (int) letter;

            if (map[index] == null) {
                String binary = Integer.toBinaryString(value);
                while (binary.length() < 8) {
                    binary = "0" + binary;
                }

                map[index] = binary;
            }
            if (isTest) {
                System.out.println(" * letter: " + letter + " -> value: " + value + " -> binary: " + map[index]);
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
