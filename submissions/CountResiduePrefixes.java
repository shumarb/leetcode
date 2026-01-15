// Question: https://leetcode.com/problems/count-residue-prefixes/description/

class CountResiduePrefixes {
    public int residuePrefixes(String s) {
        boolean[] isCounted = new boolean[26];
        int countDistinct = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!isCounted[c - 'a']) {
                countDistinct++;
                isCounted[c - 'a'] = true;
            }
            if (countDistinct == ((i + 1) % 3)) {
                result++;
            }
        }

        return result;
    }
}