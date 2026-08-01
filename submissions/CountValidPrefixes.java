// Question: https://leetcode.com/problems/count-valid-prefixes/description/

class CountValidPrefixes {
    public int countValidPrefixes(String s) {
        boolean isTest = false;
        int n = s.length();
        int result = 0;

        if (n == 1) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            String sub = s.substring(0, i + 1);
            if (isValid(sub)) {
                if (isTest) {
                    System.out.println(" * valid: [0, " + i + "]: " + sub);
                }

                result++;
            }
        }

        return result;
    }

    private boolean isValid(String s) {
        int count0 = 0;
        int count1 = 0;

        for (char c: s.toCharArray()) {
            if (c == '0') {
                count0++;
            } else {
                count1++;
            }
        }

        return Math.abs(count0 - count1) <= 1;
    }
}
