// Question: https://leetcode.com/problems/subarray-sum-equals-k/description/

class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean isTest = false;
        int prefixSum = 0;
        int result = 0;

        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            int e = nums[i];

            if (isTest) {
                System.out.println("index: " + i + ", element: " + e + "\n\n * before, prefixSum: " + prefixSum + ", map: " + map);
            }

            prefixSum += e;
            int complement = prefixSum - k;

            result += map.getOrDefault(complement, 0);
            map.put(prefixSum, 1 + map.getOrDefault(prefixSum, 0));
            if (isTest) {
                System.out.println("\n * after, prefixSum: " + prefixSum + ", map: " + map + "\n---------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}
