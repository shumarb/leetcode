// Question: https://leetcode.com/problems/find-the-degree-of-each-vertex/description/

class FindTheDegreeOfEachVertex {
    public int[] findDegrees(int[][] matrix) {
        boolean isTest = false;
        int[] result = new int[matrix.length];

        for (int[] e: matrix) {
            for (int i = 0; i < e.length; i++) {
                if (e[i] == 1) {
                    result[i]++;
                }
            }
        }
        if (isTest) {
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}
