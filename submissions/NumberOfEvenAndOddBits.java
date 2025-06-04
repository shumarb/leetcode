// Question: https://leetcode.com/problems/number-of-even-and-odd-bits/description/

class NumberOfEvenAndOddBits {
    public int[] evenOddBit(int n) {
        int[] result = new int[2];
        boolean isTest = false;
        Stack<Integer> stack = new Stack<>();

        int nCopy = n;
        while (nCopy != 0) {
            stack.push(nCopy % 2);
            nCopy /= 2;
        }

        while (!stack.isEmpty()) {
            // 1. Reduce by 1 for 0-based indexing.
            int index = stack.size() - 1;
            if (stack.peek() == 1 && index % 2 == 0) {
                result[0]++;
            } else if (stack.peek() == 1 && index % 2 != 0) {
                result[1]++;
            }
            stack.pop();
            index--;
        }
        if (isTest) {
            System.out.println("n: " + n + "\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}