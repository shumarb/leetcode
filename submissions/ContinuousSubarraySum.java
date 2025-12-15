// Question: https://leetcode.com/problems/continuous-subarray-sum/description/

class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean isTest = false;
        int runningSum = 0;

        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            runningSum += element;
            int remainder = runningSum % k;
            if (isTest) {
                System.out.println("-------------------------------\ni: " + i);
                System.out.println(" * element: " + element + "\n * runningSum: " + runningSum + "\n * remainder: " + remainder);
                System.out.println(" * before, map: " + map);
            }
            if (map.containsKey(remainder)) {
                int index = map.get(remainder);
                int len = i - map.get(remainder);
                if (isTest) {
                    System.out.println(" *** found remainder @ " + index + " -> indices of valid subarray: [" + (index + 1) + ", " + i + "]" + " -> len: " + len);
                }
                if (len > 1) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
            if (isTest) {
                System.out.println(" * after, map: " + map);
            }
        }

        return false;
    }
}