// Question: https://leetcode.com/problems/even-number-of-knight-moves/description/

class EvenNumberOfKnightMoves {
    public boolean canReach(int[] start, int[] target) {
        if (Arrays.equals(start, target)) {
            return true;
        }

        Queue<int[]> queue = new LinkedList<>();
        int level = 0;
        int n = 8;
        int[][] directions = {
                {-2, 1},
                {-2, -1},
                {-1, 2},
                {-1, -2},
                {1, 2},
                {1, -2},
                {2, -1},
                {2, 1}
        };
        boolean[][] isVisited = new boolean[n][n];
        boolean isTest = false;

        isVisited[start[0]][start[1]] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("----------------------\nlevel: " + level + "\nqueue:");
                for (int[] e: queue) {
                    System.out.println(" * " + Arrays.toString(e));
                }
            }

            int size = queue.size();
            while (size-- > 0) {
                int[] top = queue.poll();

                if (level % 2 == 0 && Arrays.equals(top, target)) {
                    if (isTest) {
                        System.out.println(" * found @ level " + level);
                    }

                    return true;
                }

                int column = top[1];
                int row = top[0];
                for (int[] direction: directions) {
                    int nextColumn = column + direction[1];
                    int nextRow = row + direction[0];

                    if (nextColumn < 0 || nextColumn >= n
                            || nextRow < 0 || nextRow >= n
                            || isVisited[nextRow][nextColumn]) {
                        continue;
                    }

                    isVisited[nextRow][nextColumn] = true;
                    queue.offer(new int[] {nextRow, nextColumn});
                }
            }

            level++;
        }

        return false;
    }
}
