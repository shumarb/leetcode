// Question: https://leetcode.com/problems/goal-parser-interpretation/description/

class GoalParserInterpretation {
    public String interpret(String command) {
        StringBuilder result = new StringBuilder();
        int n = command.length();

        for (int i = 0; i < n; i++) {
            char c = command.charAt(i);
            if (Character.isLetter(c)) {
                result.append(c);
            } else if (i + 1 < n && c == '(' && command.charAt(i + 1) == ')') {
                result.append('o');
            }
        }

        return result.toString();
    }
}