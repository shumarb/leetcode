// Question: https://leetcode.com/problems/baseball-game/description/

class BaseballGame {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        boolean isTest = false;
        int calPoints = 0;

        for (String operation: operations) {
            if (isTest) {
                System.out.println(" * before, stack: " + stack);
            }
            if (operation.equals("+")) {
                int sum = stack.get(stack.size() - 1) + stack.get(stack.size() - 2);
                stack.push(sum);
            } else if (operation.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (operation.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(operation));
            }
            if (isTest) {
                System.out.println(" * operation: " + operation);
                System.out.println(" * after, stack: " + stack);
                System.out.println("-------------------------------------");
            }
        }

        while (!stack.isEmpty()) {
            calPoints += stack.pop();
        }
        if (isTest) {
            System.out.println("calPoints: " + calPoints);
        }

        return calPoints;
    }
}