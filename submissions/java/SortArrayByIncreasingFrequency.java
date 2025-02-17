// Question: https://leetcode.com/problems/sort-array-by-increasing-frequency/description/

class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean isTest = false;

        for (int value: nums) {
            map.put(value, 1 + map.getOrDefault(value, 0));
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> e1.getValue() == e2.getValue() ? e2.getKey() - e1.getKey() : e1.getValue() - e2.getValue());
        if (isTest) {
            System.out.println("before, nums: " + Arrays.toString(nums));
            System.out.println("list: " + list);
            System.out.println("map: " + map);
        }

        int i = 0;
        for (Map.Entry<Integer, Integer> entry: list) {
            if (isTest) {
                System.out.println("entry: " + entry.getKey() + "-->" + entry.getValue());
            }
            int key = entry.getKey();
            int value = entry.getValue();
            while (value-- != 0) {
                nums[i++] = key;
            }
        }
        if (isTest) {
            System.out.println("after, nums: " + Arrays.toString(nums));
        }

        return nums;
    }
}