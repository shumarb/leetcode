// Question: https://leetcode.com/problems/majority-element-ii/description/

class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int e: nums) {
            map.merge(e, 1, Integer::sum);
        }
        for (int key: map.keySet()) {
            if (map.get(key) > n / 3) {
                result.add(key);
            }
        }

        return result;
    }
}
