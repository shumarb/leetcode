// Question: https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/description/

class MinimumNumberOfOperationsToMakeArrayEmpty {
    public int minOperations(int[] nums) {
        boolean isTest = false;
        int[] count;
        int largest = 0;
        int result = 0;

        for (int e: nums) {
            largest = Math.max(e, largest);
        }
        count = new int[largest + 1];
        for (int e: nums) {
            count[e]++;
        }

        for (int i = 1; i <= largest; i++) {
            int frequency = count[i];
            if (frequency == 1) {
                return -1;
            }

            result += ((frequency + 2) / 3);
        }
        if (isTest) {
            System.out.println("count: " + Arrays.toString(count) + "\nresult: " + result);
        }

        return result;
    }
}