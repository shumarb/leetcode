// Question: https://leetcode.com/problems/set-mismatch/description/

class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n + 1];
        boolean t = false;
        for (int x: nums) {
            freq[x]++;
        }
        if (t) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("freq: " + Arrays.toString(freq));
        }
        int[] ans = new int[2];
        for (int i = 1; i <= n; i++) {
            if (freq[i] == 2) {
                ans[0] = i;
            }
            if (freq[i] == 0) {
                ans[1] = i;
            }
        }
        if (t) {
            System.out.println("ans: " + Arrays.toString(ans));
        }
        return ans;
    }
}