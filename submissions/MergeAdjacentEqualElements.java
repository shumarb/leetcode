// Question: https://leetcode.com/problems/merge-adjacent-equal-elements/description/

class MergeAdjacentEqualElements {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> result = new ArrayList<>();
        Stack<Long> stack = new Stack<>();
        boolean isTest = false;

        for (long incoming: nums) {
            if (isTest) {
                System.out.println("incoming: " + incoming + "\n * before, stack: " + stack);
            }

            if (stack.isEmpty() || stack.peek() != incoming) {
                stack.push(incoming);
            } else {
                /**
                 1.  incoming == top-element, and sum == incoming + top-element.
                     Possible that sum == top-element of stack (if non-empty),
                     so use while loop to increment sum by top-element, then remove top-element.
                     until stack is empty or top-element != sum.
                 */
                long sum = incoming + stack.pop();
                while (!stack.isEmpty() && stack.peek() == sum) {
                    sum += stack.pop();
                }
                stack.push(sum);
            }

            if (isTest) {
                System.out.println(" * after, stack: " + stack);
                System.out.println("----------------------------------------");
            }
        }

        while (!stack.isEmpty()) {
            result.add(0, stack.pop());
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}