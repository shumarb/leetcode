// Question: https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/description/

class FindKthBitInNBinaryString {
    public char findKthBit(int n, int k) {
        StringBuilder result = new StringBuilder("0");
        boolean isTest = false;

        for (int i = 0; i < n; i++) {
            if (isTest) {
                System.out.println("before, result: " + result);
            }

            StringBuilder updated = new StringBuilder(result);
            updated.append("1");
            updated.append(getReverseAndInvert(result));
            result = updated;

            if (isTest) {
                System.out.println("after, result: " + result);
                System.out.println("----------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("final result: " + result + "\n * k: " + k + "\n * kth-bit: " + result.charAt(k - 1));
        }

        return result.charAt(k - 1);
    }

    private String getReverseAndInvert(StringBuilder part) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < part.length(); i++) {
            char c = part.charAt(i);
            if (c == '1') {
                result.append('0');
            } else {
                result.append('1');
            }
        }

        return result.reverse().toString();
    }
}