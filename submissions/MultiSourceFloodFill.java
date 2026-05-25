// Question: https://leetcode.com/problems/multi-source-flood-fill/description/

class MultiSourceFloodFill {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[n][m];
        boolean isTest = false;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] result = new int[n][m];
        int level = 0;

        Arrays.sort(sources, (a, b) -> Integer.compare(b[2], a[2]));
        for (int[] source: sources) {
            int column = source[1];
            int row = source[0];
            isVisited[row][column] = true;
            queue.offer(source);
        }

        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println("level " + level + ":");
                for (int[] source: queue) {
                    System.out.print(Arrays.toString(source) + " ");
                }
                System.out.println();
            }

            int size = queue.size();
            while (size-- > 0) {
                int[] top = queue.poll();
                int colour = top[2];
                int column = top[1];
                int row = top[0];

                result[row][column] = colour;

                for (int[] direction: directions) {
                    int nextColumn = column + direction[1];
                    int nextRow = row + direction[0];

                    if (nextColumn < 0 || nextColumn >= m || nextRow < 0 || nextRow >= n || isVisited[nextRow][nextColumn]) {
                        continue;
                    }

                    isVisited[nextRow][nextColumn] = true;
                    queue.offer(new int[] {nextRow, nextColumn, colour});
                }
            }
            if (isTest) {
                print("\nafter update:", result);
            }

            level++;
        }
        if (isTest) {
            print("result:", result);
        }

        return result;
    }

    private void print(String s, int[][] result) {
        System.out.println(s);
        for (int[] row: result) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("---------------------------------");
    }
}
