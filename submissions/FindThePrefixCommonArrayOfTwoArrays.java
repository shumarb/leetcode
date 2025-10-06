// Question: https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description/

class FindThePrefixCommonArrayOfTwoArrays {
    private int[] frequency;
    private int largest;

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        boolean isTest = false;
        int n = A.length;
        int[] C = new int[n];
        largest = A[0];

        for (int number: A) {
            largest = Math.max(largest, number);
        }
        for (int number: B) {
            largest = Math.max(largest, number);
        }
        frequency = new int[largest + 1];

        for (int i = 0; i < n; i++) {
            C[i] = update(A, B, i);
        }
        if (isTest) {
            System.out.println("C: " + Arrays.toString(C));
        }

        return C;
    }

    private int update(int[] A, int[] B, int index) {
        int count = 0;
        int n = A.length;

        frequency[A[index]]++;
        frequency[B[index]]++;

        for (int i = 0; i <= largest; i++) {
            if (frequency[i] > 1) {
                count++;
            }
        }

        return count;
    }
}