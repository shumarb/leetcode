// Question: https://leetcode.com/problems/3sum/description/

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean isTest = false;
        int n = nums.length;

        Arrays.sort(nums);
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums));
        }

        for (int i = 0; i < n - 2; i++) {
            // 1. Skip duplicates.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = n - 1;
            int target = nums[i] * -1;

            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    // 2. Skip duplicates.
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }

                    j++;
                    k--;

                } else if (sum < target) {
                    j++;

                } else {
                    k--;
                }
            }
        }

        return result;
    }
}