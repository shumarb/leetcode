// Question: https://leetcode.com/problems/subarrays-with-k-different-integers/description/

class SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countAtMost(nums, k) - countAtMost(nums, k - 1);
    }

    private int countAtMost(int[] nums, int limit) {
        boolean isTest = false;
        if (limit == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int result = 0;

        if (isTest) {
            System.out.println("-------------------------\nsubarrays with at most " + limit + " different integers: ");
        }
        for (int right = 0; right < nums.length; right++) {
            int incoming = nums[right];

            map.put(incoming, 1 + map.getOrDefault(incoming, 0));
            while (map.size() > limit) {
                int remove = nums[left++];
                map.put(remove, map.get(remove) - 1);
                if (map.get(remove) == 0) {
                    map.remove(remove);
                }
            }

            int totalSubarrays = right - left + 1;
            if (isTest) {
                System.out.println(" * " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)) + ", totalSubarrays: " + totalSubarrays);
            }

            result += totalSubarrays;
        }
        if (isTest) {
            System.out.println("\nresult: " + result);
        }

        return result;
    }
}
