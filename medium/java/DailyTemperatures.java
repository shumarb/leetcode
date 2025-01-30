// Question: https://leetcode.com/problems/daily-temperatures/description/

import java.util.Stack;

class DailyTemperatures class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> nextGreaterElementIndexStack = new Stack<> ();

        for (int i = n - 1; i >=0; i--) {
            while (!nextGreaterElementIndexStack.isEmpty() && temperatures[nextGreaterElementIndexStack.peek()] <= temperatures[i]) {
                nextGreaterElementIndexStack.pop();
            }

            if (nextGreaterElementIndexStack.isEmpty()) {
                answer[i] = 0;
            } else {
                answer[i] = nextGreaterElementIndexStack.peek() - i;
            }

            nextGreaterElementIndexStack.push(i);
        }

        return answer;
    }
}