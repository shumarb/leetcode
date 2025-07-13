// Question: https://leetcode.com/problems/diagonal-traverse/description/

class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        List<Integer> entry = new ArrayList<>();
        boolean isTest = false;
        int index = 0;
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];

        for (int diag = 0; diag < m + n - 1; diag++) {
            if (entry.size() > 0) {
                entry.clear();
            }

            int r = diag < n ? 0 : diag - n + 1;
            int c = diag < n ? diag : n - 1;

            while (r < m && c >= 0) {
                entry.add(mat[r++][c--]);
            }

            if (diag % 2 == 0) {
                Collections.reverse(entry);
            }
            for (int element: entry) {
                result[index++] = element;
            }
        }

        if (isTest) {
            System.out.println("mat:");
            for (int[] row: mat) {
                System.out.println(" * " + Arrays.toString(row));
            }
            System.out.println("--------------------------------------");
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}