// Question: https://leetcode.com/problems/numbers-with-same-consecutive-differences/description/

class NumbersWithSameConsecutiveDifferences {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list = new ArrayList<>();
        Queue<StringBuilder> queue = new LinkedList<>();
        boolean isTest = false;
        int[] result;
        int level = 0;

        if (isTest) {
            System.out.println("n: " + n + "\nk: " + k);
        }

        for (int i = 1; i <= 9; i++) {
            queue.offer(new StringBuilder().append(i));
        }
        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("------------------------------------");
                System.out.println("level " + level + ": " + queue);
            }

            if (level == n - 1) {
                break;
            }

            int size = queue.size();
            while (size-- > 0) {
                StringBuilder nextNumber;
                StringBuilder top = queue.poll();
                int digit = top.charAt(top.length() - 1) - '0';
                int nextDigit;

                if (digit + k <= 9) {
                    nextDigit = digit + k;
                    queue.offer(new StringBuilder(top).append(nextDigit));
                }

                if (k != 0 && digit - k >= 0) {
                    nextDigit = digit - k;
                    queue.offer(new StringBuilder(top).append(nextDigit));
                }
            }

            level++;
        }
        while (!queue.isEmpty()) {
            list.add(Integer.parseInt(queue.poll().toString()));
        }

        result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        if (isTest) {
            System.out.println("------------------------------------\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}
