// Question: https://leetcode.com/problems/snake-in-matrix/description/

class SnakeInMatrix {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0;
        int j = 0;

        for (String command: commands) {
            if (command.equals("UP")) {
                i--;
            } else if (command.equals("DOWN")) {
                i++;
            } else if (command.equals("LEFT")) {
                j--;
            } else if (command.equals("RIGHT")) {
                j++;
            }
        }

        return (i * n) + j;
    }
}