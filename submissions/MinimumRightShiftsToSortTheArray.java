// Question: https://leetcode.com/problems/minimum-right-shifts-to-sort-the-array/description/

class MinimumRightShiftsToSortTheArray {
    public int minimumRightShifts(List<Integer> nums) {
        boolean isTest = false;
        int n = nums.size();
        int peakIndex = -1;

        for (int i = 0; i < n; i++) {
            int current = nums.get(i);
            int next = nums.get((i + 1) % n);

            if (isTest) {
                System.out.println("----------------------------------------");
                System.out.println("current: " + current + ", next: " + next);
            }
            if (next < current) {
                /**
                    1. Array can be sorted if there is at at most 1 index where next < current.
                 */
                if (peakIndex != -1) {
                    return -1;
                }
                peakIndex = i;
                if (isTest) {
                    System.out.println(" * update drop index. current: " + peakIndex);
                }
            }
        }
        if (isTest) {
            System.out.println("----------------------------------------\npeakIndex: " + peakIndex);
        }

        // 2. Edge case: If nums is sorted, peakIndex == -1.
        return peakIndex == -1 ? 0 : n - 1 - peakIndex;
    }
}