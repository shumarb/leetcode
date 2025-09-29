// Question: https://leetcode.com/problems/decompress-run-length-encoded-list/description/

class DecompressRunLengthEncodedList {
    public int[] decompressRLElist(int[] nums) {
        boolean isTest = false;
        int[] result;
        int k = 0;
        int n = nums.length;
        int totalFrequency = 0;

        for (int i = 0; i < n; i += 2) {
            totalFrequency += nums[i];
        }
        result = new int[totalFrequency];
        for (int i = 0; i < n; i += 2) {
            int freq = nums[i];
            int val = nums[i + 1];
            Arrays.fill(result, k, k + freq, val);
            k += freq;
        }
        if (isTest) {
            System.out.println("totalFrequency: " + totalFrequency + "\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}