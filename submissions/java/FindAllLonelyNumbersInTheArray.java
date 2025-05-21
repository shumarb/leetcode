// Question: https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/description/

class FindAllLonelyNumbersInTheArray {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int number: nums) {
            set.add(number);
            map.put(number, 1 + map.getOrDefault(number, 0));
        }
        for (int number: nums) {
            int left = number - 1;
            int right = number + 1;
            if (map.get(number) == 1 && !set.contains(left) && !set.contains(right)) {
                result.add(number);
            }
        }

        return result;
    }
}