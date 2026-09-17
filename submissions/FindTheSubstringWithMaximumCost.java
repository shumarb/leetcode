// Question: https://leetcode.com/problems/find-the-substring-with-maximum-cost/description/

class FindTheSubstringWithMaximumCost {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        char[] charsLetters = chars.toCharArray();
        char[] letters = s.toCharArray();
        int[] costPerLetter = new int[26];
        int currentCost;
        int n = letters.length;
        int result = 0;

        for (int i = 0; i < 26; i++) {
            costPerLetter[i] = i + 1;
        }
        for (int i = 0; i < vals.length; i++) {
            costPerLetter[charsLetters[i] - 'a'] = vals[i];
        }

        currentCost = result = costPerLetter[letters[0] - 'a'];
        for (int right = 1; right < n; right++) {
            int cost = costPerLetter[letters[right] - 'a'];
            currentCost = Math.max(currentCost + cost, cost);
            result = Math.max(currentCost, result);
        }

        return result < 0 ? 0 : result;
    }
}
