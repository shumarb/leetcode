// Question: https://leetcode.com/problems/separate-the-digits-in-an-array/description/

class SeparateTheDigitsInAnArray {
    public int[] separateDigits(int[] nums) {
        boolean isTest = false;
        int[] result;
        int index;
        int size = 0;

        for (int e: nums) {
            while (e > 0) {
                e /= 10;
                size++;
            }
        }
        if (isTest) {
            System.out.println("size: " + size);
        }

        result = new int[size];
        index = size - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int number = nums[i];
            while (number > 0) {
                result[index--] = number % 10;
                number /= 10;
            }
        }
        if (isTest) {
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}
