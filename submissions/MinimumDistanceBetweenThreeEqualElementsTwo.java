// Question: https://leetcode.com/problems/minimum-distance-between-three-equal-elements-ii/description/

class MinimumDistanceBetweenThreeEqualElementsTwo {
    public int minimumDistance(int[] nums) {
        List<Integer>[] map;
        int largest = Integer.MIN_VALUE;
        int result = Integer.MAX_VALUE;

        for (int e: nums) {
            largest = Math.max(e, largest);
        }
        map = new List[largest + 1];
        for (int i = 1; i <= largest; i++) {
            map[i] = new ArrayList<>();
        }

        for (int c = 0; c < nums.length; c++) {
            int key = nums[c];
            map[key].add(c);

            if (map[key].size() >= 3) {
                List<Integer> value = map[key];
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