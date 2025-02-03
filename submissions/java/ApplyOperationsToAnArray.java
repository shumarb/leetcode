// Question: https://leetcode.com/problems/apply-operations-to-an-array/description/

class ApplyOperationsToAnArray {
    public int[] applyOperations(int[] nums) {
        boolean t = false;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        if (t) {
            print("after op, nums: ", nums);
        }

        int k = 0;
        for (int x: nums) {
            if (x != 0) {
                nums[k++] = x;
            }
        }
        for (int i = k; i < len; i++) {
            nums[i] = 0;
        }

        if (t) {
            print("final: ", nums);
        }
        return nums;
    }

    private void swap(int[] n, int l, int h) {
        int temp = n[h];
        n[h] = n[l];
        n[l] = temp;
    }

    private void print(String s, int[] n) {
        System.out.println(s + Arrays.toString(n));
    }
}