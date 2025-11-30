// Question: https://leetcode.com/problems/crawler-log-folder/description/

class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        boolean isTest = false;

        for (String log: logs) {
            if (isTest) {
                System.out.println("log: " + log + "\n * before, stack: " + stack);
            }

            // 1. Edge case: Stay at current folder, or currently at main folder and log is "../".
            if (log.equals("./") || stack.isEmpty() && log.equals("../")) {
                continue;
            }
            if (!stack.isEmpty() && log.equals("../")) {
                stack.pop();
            } else {
                stack.push(log);
            }
            if (isTest) {
                System.out.println(" * after, stack: " + stack);
                System.out.println("------------------------------------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("------------------------------------------------------------------------\nfinal stack: " + stack);
        }

        return stack.size();
    }
}