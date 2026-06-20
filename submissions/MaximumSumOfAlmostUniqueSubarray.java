// Question: https://leetcode.com/problems/maximum-sum-of-almost-unique-subarray/description/

class MaximumSumOfAlmostUniqueSubarray {
    public long maxSum(List<Integer> nums, int m, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.size();
        int[] arr = new int[n];
        long sum = 0;
        long result = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = nums.get(i);
        }
        for (int i = 0; i < k; i++) {
            int incoming = arr[i];
            sum += incoming;
            map.put(incoming, 1 + map.getOrDefault(incoming, 0));
        }
        if (map.size() >= m) {
            result = sum;
        }

        for (int i = k; i < n; i++) {
            int remove = arr[i - k];
            sum -= remove;
            map.put(remove, map.get(remove) - 1);
            if (map.get(remove) == 0) {
                map.remove(remove);
            }

            int incoming = arr[i];
            sum += incoming;
            map.put(incoming, 1 + map.getOrDefault(incoming, 0));

            if (map.size() >= m) {
                result = Math.max(result, sum);
            }
        }

        return result;
    }
}
