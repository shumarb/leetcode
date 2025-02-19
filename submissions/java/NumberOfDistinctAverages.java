// Question: https://leetcode.com/problems/number-of-distinct-averages/description/

class NumberOfDistinctAverages {
    public int distinctAverages(int[] nums) {
        Set<Double> averages = new HashSet<>();
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
            double average = (nums[low] + nums[high]) / 2.0;
            if (isTest) {
                System.out.println("elements: " + nums[low] + " & " + nums[high] + " | average: " + average);
            }
            averages.add(average);
            if (isTest) {
                System.out.println("averages so far: " + averages);
            }

            if (nums[low] == nums[high]) {
                high--;
            } else {
                low++;
                high--;
            }
        }
        if (isTest) {
            System.out.println("averages: " + averages);
        }

        return averages.size();
    }
}