// Question: https://leetcode.com/problems/degree-of-an-array/description/

class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> firstIndex = new HashMap<>();
        Map<Integer, Integer> lastIndex = new HashMap<>();
        boolean isTest = false;
        int degree = 0;

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            count.put(number, 1 + count.getOrDefault(number, 0));
            firstIndex.putIfAbsent(number, i);
            lastIndex.put(number, i);
            degree = Math.max(degree, count.get(number));
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("count: " + count + "\nfirstIndex: " + firstIndex);
            System.out.println("lastIndex: " + lastIndex);
        }

        int result = Integer.MAX_VALUE;
        for (int number: count.keySet()) {
            if (count.get(number) == degree) {
                result = Math.min(result, lastIndex.get(number) - firstIndex.get(number) + 1);
            }
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}