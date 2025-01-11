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

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<> (
                (a, b) -> b.getValue() - a.getValue()
        );
        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            if (e.getValue() > (nums.length / 2)) {
                maxHeap.offer(e);
            }
        }
        if (t) {
            System.out.println("maxHeap: " + maxHeap);
        }

        return maxHeap.peek().getKey();
    }
}
