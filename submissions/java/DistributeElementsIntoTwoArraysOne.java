// Question: https://leetcode.com/problems/distribute-elements-into-two-arrays-i/description/

class DistributeElementsIntoTwoArraysOne {
    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        boolean isTest = false;

        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("arr1: " + arr1 + "\narr2: " + arr2);
        }

        int j = 0;
        for (int number: arr1) {
            nums[j++] = number;
        }
        for (int number: arr2) {
            nums[j++] = number;
        }

        return nums;
    }
}