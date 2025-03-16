// Question: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/description/

class RemoveAllAdjacentDuplicatesInStringTwo {
    public String removeDuplicates(String s, int k) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        Stack<int[]> stack = new Stack<>();

        for (char letter: s.toCharArray()) {
            if (isTest) {
                System.out.println("inserting: " + letter);
                display("before | stack:", stack);
                System.out.println();
            }
            if (!stack.isEmpty() && stack.peek()[0] == letter) {
                stack.peek()[1]++;
                if (stack.peek()[1] == k) {
                    stack.pop();
                }
            } else {
                stack.push(new int[] {letter, 1});
            }
            if (isTest) {
                display("after | stack:", stack);
                System.out.println("----------------------------------------------------------------------");
            }
        }
        if (isTest) {
            display("final stack:", stack);
        }

        while (!stack.isEmpty()) {
            int[] entry = stack.pop();
            for (int i = 0; i < entry[1]; i++) {
                result.append((char) entry[0]);
            }
        }
        result = result.reverse();
        if (isTest) {
            System.out.println("result: " + result.toString());
        }

        return result.toString();
    }

    private void display(String str, Stack<int[]> stack) {
        System.out.println(str);
        for (int[] entry: stack) {
            System.out.println(" * [letter: " + (char) entry[0] + ", frequency: " + entry[1] + "]");
        }
    }
}