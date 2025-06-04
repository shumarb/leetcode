// Question: https://leetcode.com/problems/number-of-visible-people-in-a-queue/description/

class NumberOfVisiblePeopleInAQueue {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] answer = new int[n];
        boolean isTest = false;
        Stack<Integer> stack = new Stack<>();

        if (isTest) {
            System.out.println("heights: " + Arrays.toString(heights));
        }

        // 1. Edge case: only 1 person in queue, return answer containing element of 0.
        if (heights.length == 1) {
            return answer;
        }

        for (int i = n - 1; i >= 0; i--) {
            // 2. Number of people current element can see to its right.
            int count = 0;
            int current = heights[i];
            if (isTest) {
                System.out.println("-------------------------------------------------------------");
                System.out.println("current: " + current + ", index: " + i);
                System.out.println("before, stack: " + stack);
            }

            /**
             3.  Count number of people shorter than current
             until stack is empty or person taller than current is encountered.
             */
            while (!stack.isEmpty() && current > stack.peek()) {
                stack.pop();
                count++;
            }

            /**
             4.  Stack is not empty, so there exists >= 1 person encountered is taller than current.
             Current can see this person, so increase number of people it sees by 1.
             */
            if (!stack.isEmpty() && current < stack.peek()) {
                count++;
            }

            /**
             5.  Confirm number of people that current element at index i can seen,
             and add current to stack for next iteration.
             */
            answer[i] = count;
            stack.push(current);

            if (isTest) {
                System.out.println("after, stack: " + stack);
            }
        }
        if (isTest) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("final stack: " + stack + ", final answer: " + Arrays.toString(answer));
        }

        return answer;
    }
}