// Question: https://leetcode.com/problems/snake-in-matrix/description/

class SnakeInMatrix {
    public int finalPositionOfSnake(int n, List<String> commands) {
        boolean isTest = false;
        int[][] grid = new int[n][n];
        int k = 0;
        int x = 0;
        int y = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = k++;
            }
        }
        for (String command: commands) {
            if (command.equals("UP")) {
                x--;
            } else if (command.equals("DOWN")) {
                x++;
            } else if (command.equals("LEFT")) {
                y--;
            } else if (command.equals("RIGHT")) {
                y++;
            }
        }
        if (isTest) {
            System.out.println("grid:");
            for (int[] e: grid) {
                System.out.println(Arrays.toString(e));
            }
            System.out.println("-------------------------------------------");
            System.out.println("x: " + x + ", y: " + y + " -> answer: " + grid[x][y]);
        }

        return grid[x][y];
    }
}