// Question: https://leetcode.com/problems/find-all-groups-of-farmland/description/

class FindAllGroupsOfFarmland {
    private int[][] land;
    private int m;
    private int n;

    public int[][] findFarmland(int[][] land) {
        List<int[]> coordinates = new ArrayList<>();
        boolean isTest = false;
        int[][] result = new int[0][0];
        m = land.length;
        n = land[0].length;
        this.land = land;

        if (isTest) {
            System.out.println("land:");
            for (int[] row: land) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("------------------------------------");
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0) {
                    continue;
                }

                int[] coordinate = dfs(i, j);
                if (isTest) {
                    System.out.println("farmland | coordinate: " + Arrays.toString(coordinate));
                }
                coordinates.add(coordinate);
            }
        }

        if (coordinates.size() > 0) {
            result = new int[coordinates.size()][4];
            for (int i = 0; i < coordinates.size(); i++) {
                result[i] = coordinates.get(i);
            }
        }
        if (isTest) {
            System.out.println("------------------------------------\nresult:");
            for (int[] e: coordinates) {
                System.out.println(Arrays.toString(e));
            }
        }

        return result;
    }

    private int[] dfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        int[] result = new int[4];

        result[0] = i;
        result[1] = j;

        queue.offer(new int[] {i, j});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] top = queue.poll();
                int column = top[1];
                int row = top[0];

                land[row][column] = 0;
                result[2] = row;
                result[3] = column;

                int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                for (int[] direction: directions) {
                    int adjacentColumn = column + direction[1];
                    int adjacentRow = row + direction[0];

                    if (adjacentColumn < 0 || adjacentColumn >= n || adjacentRow < 0 || adjacentRow >= m
                            || land[adjacentRow][adjacentColumn] == 0) {
                        continue;
                    }
                    land[adjacentRow][adjacentColumn] = 0;
                    queue.offer(new int[] {adjacentRow, adjacentColumn});
                }
            }
        }

        return result;
    }
}
