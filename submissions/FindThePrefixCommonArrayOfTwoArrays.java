// Question: https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description/

class FindThePrefixCommonArrayOfTwoArrays {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        boolean isTest = false;
        int largest = Integer.MIN_VALUE;
        int n = A.length;
        int[] C = new int[n];
        int[] frequency;

        for (int number: A) {
            largest = Math.max(largest, number);
        }
        for (int number: B) {
            largest = Math.max(largest, number);
        }
        frequency = new int[largest + 1];

        for (int i = 0; i < n; i++) {
            int count = 0;

            frequency[A[i]]++;
            frequency[B[i]]++;
            for (int j = 1; j <= largest; j++) {
                if (frequency[j] > 1) {
                    count++;
                }
            }

            C[i] = count;
        }
        if (isTest) {
            System.out.println("C: " + Arrays.toString(C));
        }

        return C;
    }
}