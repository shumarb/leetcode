// Question: https://leetcode.com/problems/increasing-decreasing-string/description/

class IncreasingDecreasingString {
    public String sortString(String s) {
        StringBuilder result = new StringBuilder();
        int[] count = new int[26];

        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }

        while (isValid(count)) {
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    result.append((char) ('a' + i));
                    count[i]--;
                }
            }

            if (isValid(count)) {
                for (int i = 25; i >= 0; i--) {
                    if (count[i] > 0) {
                        result.append((char) ('a' + i));
                        count[i]--;
                    }
                }

            } else {
                break;
            }
        }

        return result.toString();
    }

    private boolean isValid(int[] count) {
        for (int e: count) {
            if (e > 0) {
                return true;
            }
        }

        return false;
    }
}