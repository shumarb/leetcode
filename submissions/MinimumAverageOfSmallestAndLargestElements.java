// Question: https://leetcode.com/problems/minimum-average-of-smallest-and-largest-elements/description/

class MinimumAverageOfSmallestAndLargestElements {
    public double minimumAverage(int[] nums) {
        double minimumAverage = Double.MAX_VALUE;
        boolean isTest = false;

        if (isTest) {
            System.out.println("before sort, nums: " + Arrays.toString(nums));
        }
        Arrays.sort(nums);
        if (isTest) {
            System.out.println("after sort, nums: " + Arrays.toString(nums));
        }

        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            double currentAverage = (nums[low] + nums[high]) / 2.0;
            if (isTest) {
                System.out.println("minimum average so far: " + minimumAverage);
                System.out.println("elements: " + nums[low] + " & " + nums[high] + " | current average: " + currentAverage);
            }
            if (currentAverage < minimumAverage) {
                minimumAverage = currentAverage;
            }
            low++;
            high--;
        }
        if (isTest) {
            System.out.println("final minimum average: " + minimumAverage);
        }

        return minimumAverage;
    }
}