// Question: https://leetcode.com/problems/majority-element-ii/description/

class MajorityElementTwo {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int number: nums) {
            map.put(number, 1 + map.getOrDefault(number, 0));
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > nums.length / 3) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}