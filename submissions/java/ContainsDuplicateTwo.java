// Question: https://leetcode.com/problems/contains-duplicate-ii/description/

class ContainsDuplicateTwo {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<> ();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (Math.abs(map.get(nums[i]) - i) <= k)) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}