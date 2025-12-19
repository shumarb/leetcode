// Question: https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/description/

class MinimumAbsoluteDistanceBetweenMirrorPairs {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int reverse = reverse(current);
            if (map.containsKey(current)) {
                result = Math.min(Math.abs(i - map.get(current)), result);
            }
            map.put(reverse, i);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int reverse(int n) {
        int result = 0;

        while (n > 0) {
            result *= 10;
            result += n % 10;
            n /= 10;
        }

        return result;
    }
}