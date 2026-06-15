// Question: https://leetcode.com/problems/subarrays-with-k-different-integers/description/

class SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countAtMost(nums, k) - countAtMost(nums, k - 1);
    }

    private int countAtMost(int[] nums, int limit) {
        Map<Integer, Integer> map = new HashMap<>();
        int countDistinct = 0;
        int left = 0;
        int result = 0;

        for (int right = 0; right < nums.length; right++) {
            int incoming = nums[right];

            map.put(incoming, 1 + map.getOrDefault(incoming, 0));
            if (map.get(incoming) == 1) {
                countDistinct++;
            }

            while (countDistinct > limit) {
                int remove = nums[left++];

                map.put(remove, map.get(remove) - 1);
                if (map.get(remove) == 0) {
                    countDistinct--;
                    map.remove(remove);
                }
            }

            result += (right - left + 1);
        }
        return result;
    }
}
