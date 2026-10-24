// Question: https://leetcode.com/problems/difference-between-peaks-and-valleys/description/

class DifferenceBetweenPeaksAndValleys {
    public int peakValleyDifference(int[] nums) {
        boolean isTest = false;
        int sumPeak = 0;
        int sumValley = 0;

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
        }
        for (int i = 1; i < nums.length - 1; i++) {
            int e = nums[i];

            if (e > nums[i - 1] && e > nums[i + 1]) {
                if (isTest) {
                    System.out.println(" * peak: " + e + " @ index " + i);
                }

                sumPeak += e;

            } else if (e < nums[i - 1] && e < nums[i + 1]) {
                if (isTest) {
                    System.out.println(" * valley: " + e + " @ index " + i);
                }

                sumValley += e;
            }
        }

        return sumPeak - sumValley;
    }
}
