// Question: https://leetcode.com/problems/minimum-moves-to-convert-string/description/

class MinimumMovesToConvertString {
    public int minimumMoves(String s) {
        int minimumMoves = 0;
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == 'X') {
                minimumMoves++;
                i += 3;
            } else {
                i++;
            }
        }
        return minimumMoves;
    }
}