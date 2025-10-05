// Question: https://leetcode.com/problems/goal-parser-interpretation/description/

class GoalParserInterpretation {
    public String interpret(String command) {
        StringBuilder result = new StringBuilder();
        int n = command.length();

        for (int i = 0; i < n; ) {
            if (command.charAt(i) == 'G') {
                result.append('G');
                i++;
            } else if (command.startsWith("()", i)) {
                result.append('o');
                i += 2;
            } else if (command.startsWith("(al)", i)) {
                result.append("al");
                i += 4;
            } else {
                i++;
            }
        }

        return result.toString();
    }
}