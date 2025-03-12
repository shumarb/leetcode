// Question: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/

class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] elements = new int[m * n];
        int index = 0;
        boolean isTest = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                elements[index++] = matrix[i][j];
            }
        }
        Arrays.sort(elements);
        if (isTest) {
            System.out.println("sorted elements: " + Arrays.toString(elements) + "\nk: " + k);
        }

        return elements[k - 1];
    }
}