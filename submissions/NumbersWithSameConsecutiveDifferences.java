// Question: https://leetcode.com/problems/numbers-with-same-consecutive-differences/description/

class NumbersWithSameConsecutiveDifferences {
    public int[] numsSameConsecDiff(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        boolean isTest = false;
        int[] result = null;
        int level = 0;

        for (int i = 1; i <= 9; i++) {
            queue.offer(i);
        }
        if (isTest) {
            System.out.println("n: " + n + ", k: " + k);
            System.out.println("-------------------------------------------------------");
        }

        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println(" * level " + level + ": " + queue);
            }

            if (level++ == n - 1) {
                break;
            }

            int size = queue.size();
            while (size-- > 0) {
                int top = queue.poll();
                int lastDigit = top % 10;
                int nextDigit1 = lastDigit + k;
                int nextDigit2 = lastDigit - k;

                if (nextDigit1 <= 9) {
                    queue.offer(top * 10 + nextDigit1);
                }

                if (nextDigit1 != nextDigit2 && nextDigit2 >= 0) {
                    queue.offer(top * 10 + nextDigit2);
                }
            }
        }

        result = new int[queue.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = queue.poll();
        }
        if (isTest) {
            System.out.println("-------------------------------------------------------\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}
