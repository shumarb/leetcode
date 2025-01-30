// Question: https://leetcode.com/problems/daily-temperatures/description/

import java.util.Stack;

class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Pair> stack = new Stack<> ();

        for (int i = n - 1; i >=0; i--) {
            while (!stack.isEmpty() && stack.peek().getTemperature() <= temperatures[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                answer[i] = 0;
            } else {
                answer[i] = stack.peek().getIndex() - i;
            }

            stack.push(new Pair(temperatures[i], i));
        }

        return answer;
    }
}

class Pair {
    private final int temperature;
    private final int index;

    public Pair(int temperature, int index) {
        this.temperature = temperature;
        this.index = index;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getIndex() {
        return index;
    }
}