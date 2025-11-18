// Question: https://leetcode.com/problems/remove-outermost-parentheses/description/

class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        int end = 0;
        int start = 0;
        int sum = 0;

        while (end < s.length()) {
            if (s.charAt(end) == '(') {
                sum++;
            } else {
                sum--;
            }

            if (isTest) {
                System.out.println("i: " + end + "\n * sum: " + sum);
            }
            if (sum == 0) {
                if (isTest) {
                    System.out.println(" ** add | substring @ [" + (start + 1) + ", " + (end - 1) + "]");
                }
                result.append(s.substring(start + 1, end));
                start = end + 1;
            }
            end++;
            if (isTest) {
                System.out.println("-------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("result: " + result.toString());
        }

        return result.toString();
    }
}