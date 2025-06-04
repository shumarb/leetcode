// Question: https://leetcode.com/problems/product-of-array-except-self/description/

class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        boolean isTest = false;
        int[] result = new int[nums.length];
        int[] prefixArr = new int[nums.length];
        int[] suffixArr = new int[nums.length];
        prefixArr[0] = suffixArr[suffixArr.length - 1] = 1;
        for (int i = 1; i < prefixArr.length; i++) {
            prefixArr[i] = nums[i - 1] * prefixArr[i - 1];
        }
        for (int i = suffixArr.length - 2; i >= 0; i--) {
            suffixArr[i] = nums[i + 1] * suffixArr[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefixArr[i] * suffixArr[i];
        }

        if (isTest) {
            print("prefix:                 [", prefixArr);
            print("nums:                   [", nums);
            print("suffix:                 [", suffixArr);
            print("result:  [", nums);
        }

        return result;
    }

    private void print(String str, int[] arr) {
        System.out.print(str);
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[arr.length - 1] + "]");
    }

}