// Question: https://leetcode.com/problems/limit-occurrences-in-sorted-array/description/

class LimitOccurrencesInSortedArray {
    public int[] limitOccurrences(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        boolean isTest = false;
        int[] count = new int[101];
        int[] result = null;
        int largest = 0;
        int limit = k;

        for (int e: nums) {
            largest = Math.max(e, largest);
            count[e]++;
        }
        for (int i = 1; i <= largest; i++) {
            while (count[i] > 0 && limit > 0) {
                list.add(i);
                count[i]--;
                limit--;
            }
            limit = k;
        }
        result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("count: " + Arrays.toString(Arrays.copyOfRange(count, 0, largest + 1)) + "\nlist: " + list);
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}
