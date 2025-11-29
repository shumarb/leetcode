// Question: https://leetcode.com/problems/daily-temperatures/description/

class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        boolean isTest = false;
        int n = temperatures.length;
        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peek() - i;
            }
            if (isTest) {
                System.out.println("---------------------------------\ni: " + i + "\nstack: " + stack + "\nresult: " + Arrays.toString(result));
            }
            stack.push(i);
        }
        if (isTest) {
            System.out.println("---------------------------------\nfinal result: " + Arrays.toString(result));
        }

        return result;
    }
}