// Question: https://leetcode.com/problems/daily-temperatures/description/

import java.util.Stack;

class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] answer = new int[len];
        Stack<Integer> nextGreaterElementIndexStack = new Stack<>();

        for (int i = len - 1; i >= 0; i--) {
            // 1. Remove elements from stack until element greater than current element is found
            while (!nextGreaterElementIndexStack.isEmpty() && temperatures[nextGreaterElementIndexStack.peek()] <= temperatures[i]) {
                nextGreaterElementIndexStack.pop();
            }

            // 2. If the stack is not empty, the top element of stack is index of next greater element of current element
            // so take index of next greater element (top element of stack) - current index
            // If stack is empty, there is no element greater than current element from the right of current element,
            // hence answer[i] = 0, but since answer array has been initialised, we don't have to manually set answer[i] to 0.
            if (!nextGreaterElementIndexStack.isEmpty()) {
                answer[i] = nextGreaterElementIndexStack.peek() - i;
            }

            // 3. Lastly, add current index into stack as it could be the index of next greater element
            // of elements in temperatures array from indices [0, i - 1]
            nextGreaterElementIndexStack.push(i);
        }

        return answer;
    }
}