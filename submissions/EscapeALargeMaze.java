// Question: https://leetcode.com/problems/escape-a-large-maze/description/

class EscapeALargeMaze {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> isBlocked = new HashSet<>();
        Set<String> isVisited = new HashSet<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int limit = 1000000;

        for (int[] cell: blocked) {
            isBlocked.add(cell[0] + ", " + cell[1]);
        }

        // 1. Edge case: source or target is blocked.
        if (isBlocked.contains(source[0] + ", " + source[1]) || isBlocked.contains(target[0] + ", " + target[1])) {
            return false;
        }

        // 2. Edge case: all adjacent cells of target are banned so impossible to reach it.
        int countEnclosed = 0;
        for (int[] direction: directions) {
            int nextColumn = target[1] + direction[1];
            int nextRow = target[0] + direction[0];
            String key = nextRow + ", " + nextColumn;
            if (isBlocked.contains(key)) {
                countEnclosed++;
            }
        }
        if (countEnclosed == 4) {
            return false;
        }

        queue.offer(source);
        isVisited.add(source[0] + ", " + source[1]);

        while (!queue.isEmpty()) {
            /*
                3.  Maximum blocked cells is 200. These blocked cells form a wall.
                    The largest area that n boundary cells enclose is:

                        n * (n - 1) / 2 = (200 * 199) / 2 = 20000 cells.

                    If BFS visited all 20000 blocked cells, we have escaped any possible enclosure,
                    so there exists an exit from maze.
            */
            if (isVisited.size() > 20000) {
                return true;
            }

            int size = queue.size();
            while (size-- > 0) {
                int[] current = queue.poll();
                int column = current[1];
                int row = current[0];

                if (column == target[1] && row == target[0]) {
                    return true;
                }

                for (int[] direction: directions) {
                    int nextColumn = column + direction[1];
                    int nextRow = row + direction[0];

                    String key = nextRow + ", " + nextColumn;
                    if (nextColumn < 0 || nextColumn >= limit
                            || nextRow < 0 || nextRow >= limit
                            || isBlocked.contains(key)
                            || isVisited.contains(key)) {
                        continue;
                    }

                    if (nextColumn == target[1] && nextRow == target[0]) {
                        return true;
                    }

                    queue.offer(new int[] {nextRow, nextColumn});
                    isVisited.add(key);
                }
            }
        }

        return false;
    }
}
