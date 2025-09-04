// Question: https://leetcode.com/problems/count-substrings-that-satisfy-k-constraint-i/description/

class CountSubstringsThatSatisfyKConstraintsOne {
    public int countKConstraintSubstrings(String s, int k) {
        boolean isTest = false;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                if (isTest) {
                    System.out.println("substring: " + substring);
                }
                if (substring.length() > 0 && isValid(substring, k)) {
                    if (isTest) {
                        System.out.println(" * valid: " + substring);
                    }
                    count++;
                }
            }
            if (isTest) {
                System.out.println("---------------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("count: " + count);
        }

        return count;
    }

    private boolean isValid(String s, int k) {
        int count0 = 0;
        int count1 = 0;

        for (char c: s.toCharArray()) {
            if (c == '0') {
                count0++;
            } else {
                count1++;
            }
        }

        return count0 <= k || count1 <= k;
    }
}