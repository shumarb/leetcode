// Question: https://leetcode.com/problems/find-the-degree-of-each-vertex/description/

class FindTheDegreeOfEachVertex {
    public int[] findDegrees(int[][] matrix) {
        boolean isTest = false;
        int[] result = new int[matrix.length];

        for (int[] e: matrix) {
            for (int i = 0; i < e.length; i++) {
                result[i] += e[i];
            }
        }
        if (isTest) {
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}
