// Question: https://leetcode.com/problems/generate-parentheses/description/

class GenerateParentheses {
    private List<String> result;
    private boolean isTest;
    private int n;

    public List<String> generateParenthesis(int n) {
        isTest = false;
        result = new ArrayList<>();
        this.n = n;

        helper(new StringBuilder(), 0, 0);
        if (isTest) {
            System.out.println("-----------------------------------\nresult: " + result);
        }

        return result;
    }

    private void helper(StringBuilder current, int open, int close) {
        if (isTest) {
            System.out.println("current: " + current);
        }

        // 1. Base case: Valid parentheses formed with n '(' & ')' in correct positions.
        if (current.length() == 2 * n) {
            if (isTest) {
                System.out.println(" * adding: " + current);
                System.out.println("-----------------------------------");
            }
            result.add(current.toString());
            return;
        }

        /**
         2.  Recursive case: Explore recursive tree for valid parenthese after adding '(',
             until current has n '(', the explore recursive tree for valid parentheses
             after adding ')' until open == close.
         */
        if (open < n) {
            current.append('(');
            helper(current, open + 1, close);
            current.setLength(current.length() - 1);
        }

        if (close < open) {
            current.append(')');
            helper(current, open, close + 1);
            current.setLength(current.length() - 1);
        }
    }
}