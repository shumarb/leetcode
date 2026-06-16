// Question: https://leetcode.com/problems/process-string-with-special-operations-i/description/

class ProcessStringWithSpecialOperationsI {
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;

        for (char c: s.toCharArray()) {
            if (isTest) {
                System.out.println("c: " + c + "\n * before: " + result);
            }

            if (c >= 'a' && c <= 'z') {
                result.append(c);

            } else if (c == '*') {
                if (result.length() > 0) {
                    result.setLength(result.length() - 1);
                }

            } else if (c == '#') {
                result.append(result);

            } else if (c == '%') {
                result = result.reverse();
            }

            if (isTest) {
                System.out.println(" * after: " + result + "\n-------------------------------");
            }
        }
        if (isTest) {
            System.out.println("final result: " + result);
        }

        return result.toString();
    }
}
