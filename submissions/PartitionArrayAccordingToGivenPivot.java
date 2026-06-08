// Question: https://leetcode.com/problems/partition-array-according-to-given-pivot/description/

class PartitionArrayAccordingToGivenPivot {
    public int[] pivotArray(int[] nums, int pivot) {
        boolean isTest = false;
        int left = 0;
        int n = nums.length;
        int right = n - 1;
        int[] result = new int[n];

        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
            if (nums[i] < pivot) {
                result[left++] = nums[i];
            }
            if (nums[j] > pivot) {
                result[right--] = nums[j];
            }
        }
        if (isTest) {
            System.out.println("pivot: " + pivot + "\nleft: " + left + "\nright: " + right);
        }
        while (left <= right) {
            result[left++] = pivot;
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}
