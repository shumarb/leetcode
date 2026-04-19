// Question: https://leetcode.com/problems/find-all-groups-of-farmland/description/

class FindAllGroupsOfFarmland {
    private boolean[][] isVisited;
    private int[][] land;
    private int m;
    private int n;

    public int[][] findFarmland(int[][] land) {
        List<List<Integer>> coordinates = new ArrayList<>();
        boolean isTest = false;
        int[][] result = new int[0][0];
        m = land.length;
        n = land[0].length;
        isVisited = new boolean[m][n];
        this.land = land;

        if (isTest) {
            print("land:");
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0 || isVisited[i][j]) {
                    continue;
                }

                int[] topLeft = new int[] {i, j};
                List<Integer> list = dfs(topLeft);
                if (isTest) {
                    System.out.println("farmland | list: " + list);
                }
                coordinates.add(list);
            }
        }
        if (isTest) {
            System.out.println("------------------------------------\ncoordinates:");
            for (List<Integer> e: coordinates) {
                System.out.println(e);
            }
        }

        if (coordinates.size() > 0) {
            result = new int[coordinates.size()][4];
            for (int i = 0; i < coordinates.size(); i++) {
                for (int j = 0; j < coordinates.get(i).size(); j++) {
                    result[i][j] = coordinates.get(i).get(j);
                }
            }
        }

        return result;
    }

    private List<Integer> dfs(int[] topLeft) {
        List<Integer> values = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        int[] result = new int[] {topLeft[0], topLeft[1]};

        values.add(topLeft[0]);
        values.add(topLeft[1]);

        queue.offer(topLeft);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] top = queue.poll();
                int column = top[1];
                int row = top[0];

                isVisited[row][column] = true;
                result = top;

                int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                for (int[] direction: directions) {
                    int adjacentColumn = column + direction[1];
                    int adjacentRow = row + direction[0];

                    if (adjacentColumn < 0 || adjacentColumn >= n || adjacentRow < 0 || adjacentRow >= m
                            || land[adjacentRow][adjacentColumn] == 0 || isVisited[adjacentRow][adjacentColumn]) {
                        continue;
                    }
                    isVisited[adjacentRow][adjacentColumn] = true;
                    queue.offer(new int[] {adjacentRow, adjacentColumn});
                }
            }
        }
        values.add(result[0]);
        values.add(result[1]);

        return values;
    }

    private void print(String s) {
        System.out.println(s);
        for (int[] row: land) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("\nisVisited:");
        for (boolean[] row: isVisited) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------------------------------");
    }
}
