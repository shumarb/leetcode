// Question: https://leetcode.com/problems/majority-element/description/

class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean t = false;

        for (int x: nums) {
            map.put(x, 1 + map.getOrDefault(x, 0));
        }
        if (t) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("map: " + map);
        }

        int majKey = -1;
        int majVal = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            if (t) {
                System.out.println("entry: " + e);
            }
            if (e.getValue() > (nums.length / 2) && e.getValue() > majVal) {
                majVal = e.getValue();
                majKey = e.getKey();
            }
        }
        return majKey;
    }
}