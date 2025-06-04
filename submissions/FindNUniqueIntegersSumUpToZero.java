// Question: https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/description/

class FindNUniqueIntegersSumUpToZero {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int sum = 0;
        boolean isTest = false;

        for (int i = 0; i < n - 1; i++) {
            result[i] = i + 1;
            sum += result[i];
        }
        result[n - 1] = sum * -1;

        if (isTest) {
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}