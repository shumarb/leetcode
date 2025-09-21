// Question: https://leetcode.com/problems/largest-perimeter-triangle/description/

class LargestPerimeterTriangle {
    public int largestPerimeter(int[] nums) {
        nums = sort(nums);

        for (int i = nums.length - 1; i >= 2; i--) {
            int c = nums[i];
            int b = nums[i - 1];
            int a = nums[i - 2];
            if (a + b > c) {
                return a + b + c;
            }
        }

        return 0;
    }

    private int[] sort(int[] nums) {
        int[] frequency;
        int j = 0;
        int largest = nums[0];

        for (int number: nums) {
            largest = Math.max(largest, number);
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