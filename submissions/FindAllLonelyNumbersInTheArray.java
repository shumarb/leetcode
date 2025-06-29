// Question: https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/description/

class FindAllLonelyNumbersInTheArray {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> result = new ArrayList<>();
        boolean isTest = false;
        int largest = nums[0];

        for (int number: nums) {
            largest = Math.max(largest, number);
        }
        int[] numberFrequency = new int[largest + 2];
        for (int number: nums) {
            numberFrequency[number]++;
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nnumberFrequency: " + Arrays.toString(numberFrequency));
        }

        for (int number: nums) {
            if (numberFrequency[number] == 1) {
                // 1. Edge case: number == 0.
                if (number == 0 && numberFrequency[number + 1] == 0) {
                    result.add(number);
                } else if (number != 0 && numberFrequency[number - 1] == 0 && numberFrequency[number + 1] == 0) {
                    result.add(number);
                }
            }
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}