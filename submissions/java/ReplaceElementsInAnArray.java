// Question: https://leetcode.com/problems/replace-elements-in-an-array/description/

class ReplaceElementsInAnArray {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> elementIndexMap = new HashMap<>();
        boolean isTest = false;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            elementIndexMap.put(nums[i], i);
        }
        if (isTest) {
            System.out.println("before, nums: " + Arrays.toString(nums));
            System.out.println("elementIndexMap: " + elementIndexMap);
            System.out.println("operations:");
            for (int[] row: operations) {
                System.out.println(" * " + row[0] + " --> " + row[1]);
            }
            System.out.println("---------------------------------------------------");
        }

        for (int[] operation: operations) {
            int oldValue = operation[0];
            int newValue = operation[1];
            int index = elementIndexMap.get(oldValue);

            nums[index] = newValue;
            elementIndexMap.remove(oldValue);
            elementIndexMap.put(newValue, index);
        }
        if (isTest) {
            System.out.println("after, nums: " + Arrays.toString(nums));
        }

        return nums;
    }
}