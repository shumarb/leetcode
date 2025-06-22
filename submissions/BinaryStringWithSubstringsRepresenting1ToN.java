// Question: https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/description/

class BinaryStringWithSubstringsRepresenting1ToN {
    public boolean queryString(String s, int n) {
        boolean isTest = false;

        for (int i = 1; i <= n; i++) {
            String binary = Integer.toBinaryString(i);
            if (isTest) {
                System.out.println("i: " + i + " -> binary: " + binary);
            }
            if (s.indexOf(binary) == -1) {
                return false;
            }
        }

        return true;
    }
}