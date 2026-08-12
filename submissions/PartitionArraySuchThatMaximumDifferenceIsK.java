// Question: https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/description/

class PartitionArraySuchThatMaximumDifferenceIsK {
    public int partitionArray(int[] nums, int k) {
        boolean isTest = false;
        int left = 0;
        int result = 0;
        int right = 1;

        sort(nums);
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums) + ", k: " + k);
            System.out.println("---------------------------------------------------");
        }

        for (; right < nums.length; right++) {
            if (nums[right] - nums[left] > k) {
                if (isTest) {
                    System.out.println(" * index: [" + left + ", " + (right - 1) + "] | subarray: " + Arrays.toString(Arrays.copyOfRange(nums, left, right)));
                }

                left = right;
                result++;
            }
        }
        result++;
        if (isTest) {
            System.out.println(" * index: [" + left + ", " + (right - 1) + "] | subarray: " + Arrays.toString(Arrays.copyOfRange(nums, left, right)) + "\n---------------------------------------------------\nresult: " + result);
        }

        return result;
    }

    private void sort(int[] nums) {
        int[] count = new int[100001];
        int j = 0;
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int e: nums) {
            count[e]++;
            largest = Math.max(e, largest);
            smallest = Math.min(e, smallest);
        }

        for (int i = smallest; i <= largest; i++) {
            while (count[i]-- > 0) {
                nums[j++] = i;
            }
        }
    }
}
