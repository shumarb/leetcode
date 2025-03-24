// Question: https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/description/

class DivideArrayIntoArraysWithMaxDifference {
    private boolean isTest = false;

    public int[][] divideArray(int[] nums, int k) {
        int[][] result = new int[nums.length / 3][];
        nums = sort(nums);
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums) + "\nk: " + k);
        }

        int j = 0;
        for (int i = 0; i <= nums.length - 3; i += 3) {
            if (nums[i + 2] - nums[i] <= k) {
                result[j] = new int[] {nums[i], nums[i + 1], nums[i + 2]};
                if (isTest) {
                    System.out.println(" * valid group: " + Arrays.toString(result[j]));
                }
                j++;

            } else {
                return new int[][] {};
            }
        }

        if (isTest) {
            System.out.println("----------------------------------------------");
            System.out.println("result:");
            for (int[] group: result) {
                System.out.println(Arrays.toString(group));
            }
        }

        return result;
    }

    private int[] sort(int[] nums) {
        int maximum = nums[0];
        for (int number: nums) {
            maximum = Math.max(maximum, number);
        }
        int[] numberFrequency = new int[maximum + 1];
        for (int number: nums) {
            numberFrequency[number]++;
        }
        if (isTest) {
            System.out.println("numberFrequency: " + Arrays.toString(numberFrequency));
        }

        int j = 0;
        int[] result = new int[nums.length];
        for (int i = 0; i < numberFrequency.length; i++) {
            while (numberFrequency[i]-- > 0) {
                result[j++] = i;
            }
        }

        return result;
    }
}