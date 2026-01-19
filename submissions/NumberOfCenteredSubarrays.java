// Question: https://leetcode.com/problems/number-of-centered-subarrays/description/

class NumberOfCenteredSubarrays {
    public int centeredSubarrays(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        int result = 0;

        // 1. Edge case: Single element in array.
        if (n == 1) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            int current = nums[i];
            int sum = current;

            set.add(current);
            result++;
            if (isTest) {
                System.out.println(" * counted subarray: [" + current + "] | sum: " + sum);
            }

            for (int j = i + 1; j < n; j++) {
                int next = nums[j];
                sum += next;
                set.add(next);
                if (set.contains(sum)) {
                    if (isTest) {
                        System.out.println(" * counted subarray: " + Arrays.toString(Arrays.copyOfRange(nums, i, j + 1)) + " | sum: " + sum);
                    }
                    result++;
                }
            }
        }

        return result;
    }
}