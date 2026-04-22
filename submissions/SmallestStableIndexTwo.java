// Question: https://leetcode.com/problems/smallest-stable-index-ii/description/

class SmallestStableIndexTwo {
    public int firstStableIndex(int[] nums, int k) {
        boolean isTest = false;
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], nums[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.min(suffix[i + 1], nums[i]);
        }
        if (isTest) {
            System.out.println("prefix: " + Arrays.toString(prefix));
            System.out.println("nums:   " + Arrays.toString(nums));
            System.out.println("suffix: " + Arrays.toString(suffix));
            System.out.println("----------------------------------");
        }

        for (int i = 0; i < n; i++) {
            int maximum = prefix[i];
            int minimum = suffix[i];
            int instability = maximum - minimum;
            if (isTest) {
                System.out.println("i: " + i + " | [" + maximum + ", " + minimum + "] | instability: " + instability);
            }

            if (instability <= k) {
                if (isTest) {
                    System.out.println(" * result: " + i);
                }
                return i;
            }
        }

        return -1;
    }
}
