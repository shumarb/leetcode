// Question: https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description/

class FindThePrefixCommonArrayOfTwoArrays {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        boolean isTest = false;
        int n = A.length;
        int[] C = new int[n];

        for (int i = 0; i < n; i++) {
            C[i] = update(A, B, i);
        }
        if (isTest) {
            System.out.println("C: " + Arrays.toString(C));
        }

        return C;
    }

    private int update(int[] A, int[] B, int limit) {
        int[] frequency = new int[51];
        int count = 0;
        int n = A.length;

        for (int i = 0; i <= limit; i++) {
            frequency[A[i]]++;
            frequency[B[i]]++;
        }

        for (int i = 0; i < 51; i++) {
            if (frequency[i] > 1) {
                count++;
            }
        }

        return count;
    }
}