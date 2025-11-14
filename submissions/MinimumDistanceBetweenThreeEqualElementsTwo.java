// Question: https://leetcode.com/problems/minimum-distance-between-three-equal-elements-ii/description/

class MinimumDistanceBetweenThreeEqualElementsTwo {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int result = Integer.MAX_VALUE;

        for (int c = 0; c < nums.length; c++) {
            int key = nums[c];
            if (!map.containsKey(key)) {
                List<Integer> value = new ArrayList<>();
                value.add(c);
                map.put(key, value);
            } else {
                map.get(key).add(c);
            }

            if (map.get(key).size() >= 3) {
                List<Integer> value = map.get(key);
                int n = value.size();
                int i = value.get(n - 3);
                int j = value.get(n - 2);
                int k = value.get(n - 1);
                int absoluteDifferenceSum = Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i);
                result = Math.min(absoluteDifferenceSum, result);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}