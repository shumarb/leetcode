// Question: https://leetcode.com/problems/partition-array-according-to-given-pivot/description/

class PartitionArrayAccordingToGivenPivot {
    public int[] pivotArray(int[] nums, int pivot) {
        int j = 0;
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                result[j++] = nums[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == pivot) {
                result[j++] = nums[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > pivot) {
                result[j++] = nums[i];
            }
        }

        return result;
    }
}