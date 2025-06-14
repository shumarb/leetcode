// Question: https://leetcode.com/problems/count-complete-subarrays-in-an-array/description/

class CountCompleteSubarraysInAnArray {
    public int countCompleteSubarrays(int[] nums) {
        // 1. Edge case: nums ha 1 element.
        if (nums.length == 1) {
            return 1;
        }

        int countCompleteSubarrays = 0;
        int largest = nums[0];
        int len = nums.length;
        int totalDistinct = 0;

        for (int number: nums) {
            largest = Math.max(largest, number);
        }
        boolean[] isNumberPresent = new boolean[largest + 1];
        for (int number: nums) {
            if (!isNumberPresent[number]) {
                isNumberPresent[number] = true;
                totalDistinct++;
            }
        }

        // 2. Array comprises of elements of the same value.
        int sumOfIndices = 1;
        if (totalDistinct == 1) {
            for (int i = 2; i <= len; i++) {
                sumOfIndices += i;
            }
            return sumOfIndices;
        }

        for (int i = 0; i < len; i++) {
            int countDistinct = 1;
            boolean[] isNumberCounted = new boolean[largest + 1];
            isNumberCounted[nums[i]] = true;

            for (int j = i; j < len; j++) {
                int current = nums[j];
                if (!isNumberCounted[current]) {
                    isNumberCounted[current] = true;
                    countDistinct++;
                }
                if (countDistinct == totalDistinct) {
                    countCompleteSubarrays++;
                }
            }
        }

        return countCompleteSubarrays;
    }
}