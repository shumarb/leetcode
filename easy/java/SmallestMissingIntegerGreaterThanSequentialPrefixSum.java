// Question: https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/description/

class SmallestMissingIntegerGreaterThanSequentialPrefixSum {
    public int missingInteger(int[] nums) {
        if (nums.length == 1) {
            return nums[0] + 1;
        }

        boolean t = false;
        int ans = 0;
        int sum = getSum(nums);
        boolean[] isPresent = new boolean[sum + 1];
        int[] prefix = new int[nums.length];

        populate(prefix, nums, isPresent);
        if (t) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("prefix: " + Arrays.toString(prefix));
            System.out.println("isPresent: " + Arrays.toString(isPresent));
        }

        ans = prefix[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                ans = prefix[i];
            } else {
                break;
            }
        }
        if (t) {
            System.out.println("ans so far: " + ans);
        }

        if (isPresent[ans] && ans < isPresent.length) {
            for (int i = ans; i < isPresent.length; i++) {
                if (!isPresent[i]) {
                    ans = i;
                    break;
                }
            }
        }

        if (t) {
            System.out.println("final ans: " + ans);
        }
        return ans;
    }

    private int getSum(int[] n) {
        int s = 0;
        for (int x: n) {
            s += x;
        }
        return s;
    }

    private void populate(int[] prefix, int[] n, boolean[] isPresent) {
        prefix[0] = n[0];
        isPresent[n[0]] = true;
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + n[i];
            isPresent[n[i]] = true;
        }
    }
}