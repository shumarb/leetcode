// Question: https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/

class FrequencyOfTheMostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        boolean isTest = false;
        int maxFrequency = 0;
        int left = 0;
        long sum = 0;

        nums = sort(nums);
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums) + "\nk: " + k);
        }

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while ((long) (right - left + 1) * nums[right] > sum + k) {
                sum -= nums[left++];
            }
            maxFrequency = Math.max(maxFrequency, right - left + 1);
        }

        return maxFrequency;
    }

    private int[] sort(int[] nums) {
        int largest = nums[0];

        for (int number: nums) {
            largest = Math.max(number, largest);
        }
        int[] numberFrequency = new int[largest + 1];
        for (int number: nums) {
            numberFrequency[number]++;
        }

        int j = 0;
        for (int i = 1; i <= largest; i++) {
            while (numberFrequency[i]-- > 0) {
                nums[j++] = i;
            }
        }

        return nums;
    }
}