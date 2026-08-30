// Question: https://leetcode.com/problems/minimum-bishop-moves-to-reach-target/description/

class MinimumBishopMovesToReachTarget {
    public int minBishopMoves(int[] source, int[] target) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[9][9];
        boolean isTest = false;
        int[][] directions = {
                {1, 1},
                {1, -1},
                {-1, 1},
                {-1, -1}
        };
        int level = 0;

        queue.offer(new int[] {source[0], source[1]});
        isVisited[source[0]][source[1]] = true;

        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.print(" * level " + level + ": ");
                for (int[] e: queue) {
                    System.out.print(Arrays.toString(e) + " ");
                }
                System.out.println();
            }

            int size = queue.size();

            while (size-- > 0) {
                int[] top = queue.poll();
                int column = top[1];
                int row = top[0];

                if (Arrays.equals(top, target)) {
                    return level;
                }

                for (int[] direction: directions) {
                    int nextColumn = column + direction[1];
                    int nextRow = row + direction[0];

                    while (nextRow >= 1 && nextColumn >= 1 && nextRow <= 8 && nextColumn <= 8) {
                        if (!isVisited[nextRow][nextColumn]) {
                            queue.offer(new int[] {nextRow, nextColumn});
                            isVisited[nextRow][nextColumn] = true;
                        }

                        nextColumn += direction[1];
                        nextRow += direction[0];
                    }
                }
            }

            level++;
        }

        return -1;
    }
}
