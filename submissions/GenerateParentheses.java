// Question: https://leetcode.com/problems/generate-parentheses/description/

class GenerateParentheses {
    private List<String> result;
    private boolean isTest;
    private int n;

    public List<String> generateParenthesis(int n) {
        isTest = false;
        result = new ArrayList<>();
        this.n = n;

        dfs(new char[2 * n], 0, 0, 0);
        if (isTest) {
            System.out.println("result:");
            for (String e: result) {
                System.out.println(" * " + e);
            }
        }

        return result;
    }

    private void dfs(char[] tokens, int index, int countOpen, int countClose) {
        if (isTest) {
            System.out.println(" * index: " + index + ", countOpen: " + countOpen + ", countClose: " + countClose + " | tokens: " + Arrays.toString(tokens));
        }

        if (index == 2 * n) {
            if (isTest) {
                System.out.println(" ** valid\n-----------------------------------------------------------------------");
            }

            result.add(new String(tokens));
            return;
        }

        if (countOpen < n) {
            tokens[index] = '(';
            dfs(tokens, index + 1, countOpen + 1, countClose);
        }

        if (countClose < countOpen) {
            tokens[index] = ')';
            dfs(tokens, index + 1, countOpen, countClose + 1);
        }
    }
}
