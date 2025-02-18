// Question: https://leetcode.com/problems/minimum-average-of-smallest-and-largest-elements/description/

class MinimumAverageOfSmallestAndLargestElements {
    public double minimumAverage(int[] nums) {
        double minimumAverage = Double.MAX_VALUE;
        boolean isTest = false;

        for (int i = 0; i < nums.length / 2; i++) {
            if (isTest) {
                System.out.println("nums so far: " + Arrays.toString(nums));
            }
            int maximum = getMaximum(nums);
            int minimum = getMinimum(nums);
            double average = (maximum + minimum) / 2.0;
            if (isTest) {
                System.out.println("maximum: " + maximum + " | minimum: " + minimum + " | average: " + average);
            }
            minimumAverage = Math.min(average, minimumAverage);
            if (isTest) {
                System.out.println("minimum average so far: " + minimumAverage);
            }
            remove(nums, maximum, minimum);
            if (isTest) {
                System.out.println("after removal, nums so far: " + Arrays.toString(nums));
            }
        }

        if (isTest) {
            System.out.println("final minimum average: " + minimumAverage);
        }
        return minimumAverage;
    }

    private int getMinimum(int[] nums) {
        int minimum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                minimum = nums[i];
                break;
            }
        }

        for (int number: nums) {
            if (number != -1) {
                minimum = Math.min(minimum, number);
            }
        }
        return minimum;
    }

    private int getMaximum(int[] nums) {
        int maximum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                maximum = nums[i];
                break;
            }
        }

        for (int number: nums) {
            if (number != -1) {
                maximum = Math.max(maximum, number);
            }
        }
        return maximum;
    }

    private void remove(int[] nums, int maximum, int minimum) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == maximum) {
                nums[i] = -1;
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == minimum) {
                nums[i] = -1;
                break;
            }
        }
    }
}