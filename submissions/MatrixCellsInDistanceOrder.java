// Question: https://leetcode.com/problems/matrix-cells-in-distance-order/description/

class MatrixCellsInDistanceOrder {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        boolean isTest = false;
        int[][] result = new int[rows * cols][2];
        int k = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[k][0] = i;
                result[k++][1] = j;
            }
        }

        if (isTest) {
            display("before:", result);
        }
        Arrays.sort(result,
                (a, b) -> Integer.compare(
                        Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter), Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter)
                )
        );
        if (isTest) {
            display("after:", result);
        }

        return result;
    }

    private void display(String sentence, int[][] grid) {
        System.out.println(sentence);
        for (int[] row: grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("-------------------------------------");
    }
}