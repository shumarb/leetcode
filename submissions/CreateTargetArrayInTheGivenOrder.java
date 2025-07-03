// Question: https://leetcode.com/problems/create-target-array-in-the-given-order/description/

class CreateTargetArrayInTheGivenOrder {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        boolean isTest = false;
        int len = nums.length;
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            list.add(index[i], nums[i]);
        }
        int i = 0;
        for (int number: list) {
            result[i++] = number;
        }
        if (isTest) {
            System.out.println("nums:   " + Arrays.toString(nums) + "\nindex:  " + Arrays.toString(index));
            System.out.println("-------------------------------------------------");
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}