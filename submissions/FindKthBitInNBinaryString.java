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
            System.out.println("final result: " + result);
        }

        return result.charAt(k - 1);
    }

    private String getReverseAndInvert(StringBuilder part) {
        StringBuilder result = new StringBuilder();
        for (char c: part.toString().toCharArray()) {
            result.append(c);
        }
        for (int i = 0; i < result.length(); i++) {
            char c = result.charAt(i);
            if (c == '1') {
                result.setCharAt(i, '0');
            } else {
                result.setCharAt(i, '1');
            }
        }
        result = result.reverse();

        return result.toString();
    }
}