// Question: https://leetcode.com/problems/sliding-puzzle/description/

class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        Queue<String> queue = new LinkedList<>();
        Set<String> isVisited = new HashSet<>();
        String target = "123450";
        boolean isTest = false;
        int[][] neighbours = {
                {1, 3},
                {0, 4, 2},
                {1, 5},
                {0, 4},
                {1, 3, 5},
                {2, 4}
        };
        int result = 0;

        String key = getKey(board);
        queue.offer(key);
        isVisited.add(key);

        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("------------------------\nlevel " + result + ": " + queue);
            }

            int size = queue.size();
            while (size-- > 0) {
                String source = queue.poll();

                if (source.equals(target)) {
                    if (isTest) {
                        System.out.println(" * found @ level " + result);
                    }

                    return result;
                }

                int zeroIndex = source.indexOf('0');
                for (int nextIndex: neighbours[zeroIndex]) {
                    String next = swap(source, zeroIndex, nextIndex);
                    if (isVisited.add(next)) {
                        queue.offer(next);
                    }
                }
            }

            result++;
        }

        return -1;
    }

    private String swap(String s, int from, int to) {
        char[] digits = s.toCharArray();
        char temp = digits[from];
        digits[from] = digits[to];
        digits[to] = temp;

        return new String(digits);
    }

    private String getKey(int[][] board) {
        StringBuilder key = new StringBuilder();

        for (int[] row: board) {
            for (int e: row) {
                key.append(e);
            }
        }

        return key.toString();
    }
}
