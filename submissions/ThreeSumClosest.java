// Question: https://leetcode.com/problems/3sum-closest/description/

class ThreeSumClosest {
    private int[] nums;

    public int threeSumClosest(int[] nums, int target) {
        List<Integer> closestTriplet = new ArrayList<>();
        boolean isTest = false;
        int n = nums.length;
        int result = 0;
        this.nums = nums;

        sort();
        result = nums[0] + nums[1] + nums[2];

        if (result == target) {
            return result;
        }

        if (isTest) {
            System.out.println("target: " + target + "\nsorted nums: " + Arrays.toString(nums));
            System.out.println("-------------------------------------------------------------");
        }
        for (int i = 0; i <= n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (isTest) {
                    System.out.println(" * indices: [" + i + ", " + j + ", " + k + "] | sum: " + sum + " | triplet: [" + nums[i] + ", " + nums[j] + ", " + nums[k] + "]");
                }

                // 1. Identify triplet whose sum is closest to target.
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    closestTriplet = List.of(nums[i], nums[j], nums[k]);
                    result = sum;
                }

                // 2. Triplet's sum is target, so no other triplet exists whose sum is closer to target than this.
                if (sum == target) {
                    break;

                } else if (sum < target) {
                    j++;

                } else {
                    k--;
                }
            }
        }
        if (isTest) {
            System.out.println("-------------------------------------------------------------\nclosestTriplet: " + closestTriplet + "\nresult: " + result);
        }

        return result;
    }

    private void sort() {
        int[] count = new int[20001];
        int j = 0;
        int offset = 10000;

        for (int e: nums) {
            count[e + offset]++;
        }

        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                nums[j++] = i - offset;
            }
        }
    }
}
