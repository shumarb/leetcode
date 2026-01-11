// Question: https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/

class HowManyNumbersAreSmallerThanTheCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        boolean isTest = false;
        int largest = 0;
        int n = nums.length;
        int[] count;
        int[] result = new int[n];

        for (int e: nums) {
            largest = Math.max(e, largest);
        }
        count = new int[largest + 1];
        for (int e: nums) {
            count[e]++;
        }
        for (int i = 1; i <= largest; i++) {
            count[i] += count[i - 1];
        }
        for (int i = 0; i < n; i++) {
            int key = nums[i];
            if (key > 0) {
                result[i] = count[key - 1];
            }
        }
        if (isTest) {
            System.out.println("count: " + Arrays.toString(count) + "\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}