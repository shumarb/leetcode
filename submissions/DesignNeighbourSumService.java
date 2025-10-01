// Question: https://leetcode.com/problems/design-neighbor-sum-service/description/

class NeighborSum {
    private Map<Integer, int[]> map;
    private boolean isTest;
    private int[][] grid;

    public NeighborSum(int[][] grid) {
        isTest = false;
        map = new HashMap<>();
        this.grid = grid;
        populateMap();
    }

    private void populateMap() {
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map.put(grid[i][j], new int[] {i, j});
            }
        }
        if (isTest) {
            System.out.println("map:");
            for (Map.Entry<Integer, int[]> e: map.entrySet()) {
                System.out.println(" * " + e.getKey() + " -> " + Arrays.toString(e.getValue()));
            }
        }
    }

    public int adjacentSum(int value) {
        if (!map.containsKey(value)) {
            return 0;
        }

        int[] coordinate = map.get(value);
        int n = grid.length;
        int c = coordinate[1];
        int r = coordinate[0];
        int sum = 0;

        if (isTest) {
            System.out.println("-----------------------------------------------------\nadjacentSum:");
            System.out.println(" * value: " + value + " -> coordinate: " + Arrays.toString(coordinate));
        }

        if (r - 1 >= 0) {
            sum += grid[r - 1][c];
        }

        if (r + 1 < n) {
            sum += grid[r + 1][c];
        }

        if (c - 1 >= 0) {
            sum += grid[r][c - 1];
        }

        if (c + 1 < n) {
            sum += grid[r][c + 1];
        }

        return sum;
    }

    public int diagonalSum(int value) {
        if (!map.containsKey(value)) {
            return 0;
        }

        int[] coordinate = map.get(value);
        int n = grid.length;
        int c = coordinate[1];
        int r = coordinate[0];
        int sum = 0;

        if (isTest) {
            System.out.println("-----------------------------------------------------\ndiagonalSum:");
            System.out.println(" * value: " + value + " -> coordinate: " + Arrays.toString(coordinate));
        }

        if (r - 1 >= 0 && c - 1 >= 0) {
            sum += grid[r - 1][c - 1];
        }

        if (r - 1 >= 0 && c + 1 < n) {
            sum += grid[r - 1][c + 1];
        }

        if (r + 1 < n && c - 1 >= 0) {
            sum += grid[r + 1][c - 1];
        }

        if (r + 1 < n && c + 1 < n) {
            sum += grid[r + 1][c + 1];
        }

        return sum;
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */