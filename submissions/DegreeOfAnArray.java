// Question: https://leetcode.com/problems/degree-of-an-array/description/

class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        boolean isTest = false;
        int degree = 0;
        int largest = 0;
        int len = nums.length;
        int result = Integer.MAX_VALUE;
        int[] firstIndex;
        int[] frequency;
        int[] lastIndex;

        for (int number: nums) {
            largest = Math.max(largest, number);
        }
        firstIndex = new int[largest + 1];
        frequency = new int[largest + 1];
        lastIndex = new int[largest + 1];
        Arrays.fill(firstIndex, -1);
        Arrays.fill(lastIndex, -1);
        for (int i = 0; i < len; i++) {
            int number = nums[i];
            if (firstIndex[number] == -1) {
                firstIndex[number] = i;
            }
            lastIndex[number] = i;
            degree = Math.max(degree, ++frequency[number]);
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("firstIndex: " + Arrays.toString(firstIndex));
            System.out.println("lastIndex:  " + Arrays.toString(lastIndex));
            System.out.println("frequency:  " + Arrays.toString(frequency));
            System.out.println("degree: " + degree);
        }

        for (int number: nums) {
            if (frequency[number] == degree) {
                result = Math.min(result, lastIndex[number] - firstIndex[number] + 1);
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------------");
            System.out.println("result: " + result);
        }

        return result;
    }
}