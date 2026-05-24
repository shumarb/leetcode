// Question: https://leetcode.com/problems/limit-occurrences-in-sorted-array/description/

class LimitOccurrencesInSortedArray {
    public int[] limitOccurrences(int[] nums, int k) {
        boolean isTest = false;
        int[] count = new int[101];
        int[] result = null;
        int j = 0;
        int largest = 0;
        int size = 0;

        for (int e: nums) {
            largest = Math.max(e, largest);
            count[e]++;
        }
        for (int i = 1; i <= largest; i++) {
            size += Math.min(k, count[i]);
        }

        result = new int[size];
        for (int i = 1; i <= largest; i++) {
            if (count[i] > 0) {
                int limit = Math.min(k, count[i]);
                while (limit-- > 0) {
                    result[j++] = i;
                }
            }
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("count: " + Arrays.toString(Arrays.copyOfRange(count, 0, largest + 1)) + "\nsize: " + size);
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}
