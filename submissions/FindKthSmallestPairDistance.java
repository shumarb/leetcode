// Question: https://leetcode.com/problems/find-k-th-smallest-pair-distance/description/

class FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        boolean isTest = false;
        int n = nums.length;
        int low = 0;
        int high;

        nums = sort(nums);
        high = nums[n - 1] - nums[0];

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countPairs(nums, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums) + "\nk: " + k);
            System.out.println("low: " + low);
        }

        return low;
    }

    private int countPairs(int[] nums, int maxDistance) {
        int count = 0;
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            while (j < nums.length && nums[j] - nums[i] <= maxDistance) {
                ++j;
            }
            count += (j - i - 1);
        }
        return count;
    }

    private int[] sort(int[] nums) {
        int largest = nums[0];
        for (int number: nums) {
            largest = Math.max(largest, number);
        }
        int[] frequency = new int[largest + 1];
        for (int number: nums) {
            frequency[number]++;
        }

        int k = 0;
        for (int i = 0; i <= largest; i++) {
            while (frequency[i]-- > 0) {
                nums[k++] = i;
            }
        }

        return nums;
    }
}