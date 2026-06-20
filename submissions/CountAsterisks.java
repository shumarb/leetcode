// Question: https://leetcode.com/problems/count-asterisks/description/

class CountAsterisks {
    public int countAsterisks(String s) {
        boolean isOutside = true;
        int result = 0;

        for (char c: s.toCharArray()) {
            if (c == '|') {
                isOutside = !isOutside;
            } else if (c == '*' && isOutside) {
                result++;
            }
        }

        return result;
    }
}
