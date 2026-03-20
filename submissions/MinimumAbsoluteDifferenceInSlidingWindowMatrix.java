// Question: https://leetcode.com/problems/minimum-absolute-difference-in-sliding-submatrix/description/

class MinimumAbsoluteDifferenceInSlidingWindowMatrix {
    public int[][] minAbsDiff(int[][] grid, int k) {
        List<Integer> values = new ArrayList<>();
        boolean isTest = false;
        int c = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                List<Integer> list = new ArrayList<>();
                Set<Integer> set = new HashSet<>();
                int[][] submatrix = new int[k][k];

                for (int x = 0; x < k; x++) {
                    for (int y = 0; y < k; y++) {
                        int current = grid[i + x][j + y];
                        submatrix[x][y] = current;
                        if (!set.contains(current)) {
                            list.add(current);
                            set.add(current);
                        }
                    }
                }

                if (list.size() > 1) {
                    values.add(getMinimumAbsoluteDifference(list));
                } else {
                    values.add(0);
                }
                if (isTest) {
                    display(submatrix, list);
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = values.get(c++);
            }
        }

        return result;
    }

    private int getMinimumAbsoluteDifference(List<Integer> list) {
        Collections.sort(list);
        int result = Integer.MAX_VALUE;

        for (int i = 1; i < list.size(); i++) {
            int currentAbsoluteDifference = list.get(i) - list.get(i - 1);
            if (currentAbsoluteDifference < result) {
                result = currentAbsoluteDifference;
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    private void display(int[][] matrix, List<Integer> list) {
        System.out.println("matrix:");
        for (int[] row: matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("\nlist: " + list + "\n------------------------------------------");
    }
}
