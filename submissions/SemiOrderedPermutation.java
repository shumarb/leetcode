// Question: https://leetcode.com/problems/semi-ordered-permutation/description/

class SemiOrderedPermutation {
    public int semiOrderedPermutation(int[] nums) {
        boolean isTest = false;
        int count = 0;
        int n = nums.length;
        int x = -1;
        int y = -1;

        for (int i = 0; i < n && (x == -1 || y == -1); i++) {
            if (nums[i] == 1) {
                x = i;
            } else if (nums[i] == n) {
                y = i;
            }
        }
        if (isTest) {
            System.out.println("x: " + x + ", y: " + y);
        }

        return x < y ? x + n - y - 1 : x + n - y - 2;
    }
}