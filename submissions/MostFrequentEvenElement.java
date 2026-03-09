// Question: https://leetcode.com/problems/most-frequent-even-element/description/

class MostFrequentEvenElement {
    public int mostFrequentEven(int[] nums) {
        boolean isTest = false;
        int[] count = new int[100001];
        int largest = 0;
        int result = Integer.MIN_VALUE;
        int resultFrequency = Integer.MIN_VALUE;

        for (int e: nums) {
            largest = Math.max(e, largest);
            if (e % 2 == 0) {
                if (++count[e] > resultFrequency || count[e] == resultFrequency && e < result) {
                    result = e;
                    resultFrequency = count[e];
                }
            }
        }
        if (isTest) {
            System.out.println("count: " + Arrays.toString(Arrays.copyOfRange(count, 0, largest + 1)) + "\nresult: " + result + "\nresultFrequency: " + resultFrequency);
        }

        return result == Integer.MIN_VALUE ? -1 : result;
    }
}