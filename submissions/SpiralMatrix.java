// Question: https://leetcode.com/problems/spiral-matrix/description/

class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<> ();
        if (matrix == null) {
            return ans;
        }

        int rStart = 0;
        int rEnd = matrix.length - 1;
        int cStart = 0;
        int cEnd = matrix[0].length - 1;
        int i = 0;

        while (rStart <= rEnd && cStart <= cEnd) {
            for (i = cStart; i <= cEnd; i++) {
                ans.add(matrix[rStart][i]);
            }
            rStart++;

            for (i = rStart; i <= rEnd; i++) {
                ans.add(matrix[i][cEnd]);
            }
            cEnd--;

            if (rStart <= rEnd) {
                for (i = cEnd; i >= cStart; i--) {
                    ans.add(matrix[rEnd][i]);
                }
            }
            rEnd--;

            if (cStart <= cEnd) {
                for (i = rEnd; i >= rStart; i--) {
                    ans.add(matrix[i][cStart]);
                }
            }
            cStart++;
        }

        return ans;
    }
}