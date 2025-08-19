// Question: https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/description/

class MinimumSubsequenceInNonIncreasingOrder {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList<>();
        boolean isTest = false;
        int i = nums.length - 1;
        int total = 0;
        int totalComplement = 0;

        nums = sort(nums);
        for (int number: nums) {
            total += number;
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\ntotal: " + total);
            System.out.println("---------------------------------------------------");
        }

        while (total >= totalComplement) {
            int current = nums[i];
            total -= current;
            totalComplement += current;
            result.add(current);
            if (isTest) {
                System.out.println("total: " + total + ", totalComplement: " + totalComplement + ", result so far: " + result);
                System.out.println("---------------------------------------------------");
            }
            i--;
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }

    private int[] sort(int[] nums) {
        int[] frequency;
        int j = 0;
        int largest = nums[0];

        for (int i = 1; i < nums.length; i++) {
            largest = Math.max(largest, nums[i]);
        }
        frequency = new int[largest + 1];
        for (int number: nums) {
            frequency[number]++;
        }

        for (int i = 1; i <= largest; i++) {
            while (frequency[i]-- > 0) {
                nums[j++] = i;
            }
        }

        return nums;
    }
}