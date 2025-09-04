// Question: https://leetcode.com/problems/count-substrings-that-satisfy-k-constraint-i/description/

class CountSubstringsThatSatisfyKConstraintsOne {
    public int countKConstraintSubstrings(String s, int k) {
        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            int count0 = 0;
            int count1 = 0;

            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '0') {
                    count0++;
                } else {
                    count1++;
                }

                if (count0 <= k || count1 <= k) {
                    total++;
                } else {
                    break;
                }
            }
        }

        return total;
    }
}