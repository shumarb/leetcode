// Question: https://leetcode.com/problems/replace-elements-in-an-array/description/

class ReplaceElementsInAnArray {
    public int[] arrayChange(int[] nums, int[][] operations) {
        boolean isTest = false;
        int[] elementIndexMap;
        int largest = 0;
        int len = nums.length;

        for (int number: nums) {
            largest = Math.max(largest, number);
        }
        for (int[] row: operations) {
            largest = Math.max(largest, Math.max(row[0], row[1]));
        }
        elementIndexMap = new int[largest + 1];
        for (int i = 0; i < len; i++) {
            elementIndexMap[nums[i]] = i;
        }
        if (isTest) {
            System.out.println("before, nums: " + Arrays.toString(nums));
            System.out.println("operations:");
            for (int[] row: operations) {
                System.out.println(" * " + row[0] + " --> " + row[1]);
            }
            System.out.println("---------------------------------------------------");
        }

        for (int[] operation: operations) {
            int oldValue = operation[0];
            int newValue = operation[1];
            int index = elementIndexMap[oldValue];
            nums[index] = newValue;
            elementIndexMap[newValue] = index;
        }
        if (isTest) {
            System.out.println("after, nums: " + Arrays.toString(nums));
        }

        return nums;
    }
}