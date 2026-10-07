// Question: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/

class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        int countClose = 0;
        int countOpen = 0;

        for (char c: s.toCharArray()) {
            if (c == '(') {
                countOpen++;

            } else {
                if (countOpen > 0) {
                    countOpen--;

                } else {
                    countClose++;
                }
            }
        }

        return countOpen + countClose;
    }
}
