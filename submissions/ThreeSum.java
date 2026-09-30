// Question: https://leetcode.com/problems/3sum/description/

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean isTest = false;
        int n = nums.length;

        Arrays.sort(nums);
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums) + "\n-------------------------------------------------------");
        }

        // 1. There must be >= 2 elements after i for a valid triplet, hence, i ranges from [0, n - 3]
        for (int i = 0; i <= n - 3; i++) {
            int current = nums[i];

            // 2. Skip duplicates and set i-th element as last element of duplicate.
            if (i > 0 && current == nums[i - 1]) {
                continue;
            }

            // 3. If i-th element is positive, impossible to find valid triplet as all elements after it are positive.
            if (current > 0) {
                break;
            }

            int j = i + 1;
            int k = n - 1;
            int target = current * -1;

            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum == target) {
                    if (isTest) {
                        System.out.println(" * indices: [" + i + ", " + j + ", " + k + "] | elements: [" + current + ", " + nums[j] + ", " + nums[k] + "]");
                    }

                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // 4. Skip to first and last duplicates of k-th and j-th elements respectively.
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }

                    // 5. Increment j-th and k-th pointers to start search with new elements whilst maintaining i-th element.
                    // Eg: search [-5 1 4], now search in range [-5 2 3].
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
