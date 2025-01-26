// Question: https://leetcode.com/problems/xor-operation-in-an-array/description/

class XorOperationInAnArray {
    public int xorOperation(int n, int start) {
        int[] nums = new int[n];
        boolean isTest = false;
        for (int i = 0; i < n; i++) {
            nums[i] = start + 2 * i;
        }
        if (isTest) {
            System.out.println("n: " + n + ", start: " + start + "\nnums: " + Arrays.toString(nums));
        }
        int xOrValue = 0;
        for (int element: nums) {
            if (isTest) {
                System.out.println("before | current xOrValue: " + xOrValue + ", current element: " + element);
            }
            xOrValue = xOrValue ^ element;
            if (isTest) {
                System.out.println("after | current xOrValue: " + xOrValue);
            }
        }

        if (isTest) {
            System.out.println("final xOrValue: " + xOrValue);
        }
        return xOrValue;
    }
}