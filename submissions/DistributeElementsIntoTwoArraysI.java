// Question: https://leetcode.com/problems/distribute-elements-into-two-arrays-i/description/

class DistributeElementsIntoTwoArraysI {
    public int[] resultArray(int[] nums) {
        int index1 = 0;
        int index2 = 0;
        int n = nums.length;
        int[] arr2 = new int[n];
        int[] result = new int[n];

        arr2[index2++] = nums[1];
        result[index1++] = nums[0];
        for (int i = 2; i < n; i++) {
            int current = nums[i];

            if (result[index1 - 1] > arr2[index2 - 1]) {
                result[index1++] = current;
            } else {
                arr2[index2++] = current;
            }
        }
        for (int i = 0; i < index2; i++) {
            result[index1++] = arr2[i];
        }

        return result;
    }
}
