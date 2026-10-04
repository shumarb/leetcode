// Question: https://leetcode.com/problems/4sum/description/

class FourSum {
    private List<List<Integer>> result;
    private boolean isTest;
    private int[] nums;
    private int i;
    private int j;
    private int n;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        isTest = false;
        n = nums.length;
        result = new ArrayList<>();
        this.nums = nums;

        Arrays.sort(nums);
        if (isTest) {
            System.out.println("target: " + target + "\nsorted nums: " + Arrays.toString(nums));
            System.out.println("-------------------------------------------------------------");
        }
        for (i = 0; i <= n - 4; i++) {
            // 1. If there are duplicates, set i-th and j-th elements as its respective last duplicates.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (j = i + 1; j <= n - 3; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                twoSum((long) target - nums[i] - nums[j]);
            }
        }

        return result;
    }

    private void twoSum(long key) {
        int k = j + 1;
        int l = n - 1;

        while (k < l) {
            long sum = nums[k] + nums[l];

            if (sum == key) {
                List<Integer> quadruplet = List.of(nums[i], nums[j], nums[k], nums[l]);
                result.add(quadruplet);

                if (isTest) {
                    System.out.println(" * indices: [" + i + ", " + j + ", " + k + ", " + l + "] | quadruplet: " + quadruplet);
                }

                // 2. Set next k-th and l-th elements as next unique values.
                while (k < l && nums[k] == nums[k + 1]) {
                    k++;
                }

                while (k < l && nums[l] == nums[l - 1]) {
                    l--;
                }

                k++;
                l--;

            } else if (sum < key) {
                k++;

            } else {
                l--;
            }
        }
    }
}
