// Question: https://leetcode.com/problems/two-out-of-three/description/

class TwoOutOfThree {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set1 = getSet(nums1);
        Set<Integer> set2 = getSet(nums2);
        Set<Integer> set3 = getSet(nums3);
        Map<Integer, Integer> map = new HashMap<>();
        boolean isTest = false;

        for (int num: set1) {
            map.put(num, 1 + map.getOrDefault(num, 0));
        }
        for (int num: set2) {
            map.put(num, 1 + map.getOrDefault(num, 0));
        }
        for (int num: set3) {
            map.put(num, 1 + map.getOrDefault(num, 0));
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() >= 2) {
                result.add(entry.getKey());
            }
        }

        if (isTest) {
            System.out.println("set1: " + set1);
            System.out.println("set2: " + set2);
            System.out.println("set3: " + set3);
            System.out.println("map: " + map);
            System.out.println("result: " + result);
        }

        return result;
    }

    private Set<Integer> getSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        return set;
    }

}