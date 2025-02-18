// Question: https://leetcode.com/problems/number-of-distinct-averages/description/

class NumberOfDistinctAverages {
    public int distinctAverages(int[] nums) {
        Set<Double> averages = new HashSet<>();
        boolean isTest = false;

        while (countNegatives(nums) != nums.length) {
            if (isTest) {
                System.out.println("nums so far: " + Arrays.toString(nums));
            }
            int maximum = getMaximum(nums);
            int minimum = getMinimum(nums);
            double average = (maximum + minimum) / 2.0;
            if (isTest) {
                System.out.println("maximum: " + maximum + " | minimum: " + minimum + " | average: " + average);
            }
            averages.add(average);
            if (isTest) {
                System.out.println("averages so far: " + averages);
                System.out.println("nums before removals: " + Arrays.toString(nums));
            }
            remove(maximum, minimum, nums);
            if (isTest) {
                System.out.println("nums after removals: " + Arrays.toString(nums));
            }
        }
        if (isTest) {
            System.out.println("averages final: " + averages);
        }

        return averages.size();
    }

    private void remove(int maximum, int minimum, int[] nums) {
        if (maximum == minimum) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == maximum) {
                    nums[i] = -1;
                    break;
                }
            }

        } else {
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

    private int countNegatives(int[] nums) {
        int count = 0;
        for (int number: nums) {
            if (number == -1) {
                count++;
            }
        }
        return count;
    }
}