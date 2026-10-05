// Question: https://leetcode.com/problems/score-of-parentheses/description/

class ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        boolean isTest = false;
        char[] tokens = s.toCharArray();
        int depth = 0;
        int result = 0;

        if (isTest) {
            System.out.print("s: " + s + "\n------------------------------------------------------------");
        }
        for (int i = 0; i < tokens.length; i++) {
            char c = tokens[i];

            if (isTest) {
                System.out.println("\ni: " + i + ", incoming: " + c + "\n * before: " + stack + ", depth: " + depth);
            }

            if (c == '(') {
                depth++;
                stack.push(c);

            } else {
                stack.pop();

                if (tokens[i - 1] == '(') {
                    int score = (int) Math.pow(2, depth - 1);

                    if (isTest) {
                        System.out.println(" * valid | depth " + depth + ", score: " + score);
                    }

                    result += score;
                }

                depth--;
            }

            if (isTest) {
                System.out.println(" * after: " + stack + ", depth: " + depth);
            }
        }
        if (isTest) {
            System.out.print("------------------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
