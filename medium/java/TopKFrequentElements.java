// Question: https://leetcode.com/problems/top-k-frequent-elements/description/

class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<> ();
        int[] ans = new int[k];

        for (int x: nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<> (
                (a, b) -> map.get(a) - map.get(b)
        );
        for (int num: map.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int i = 0;
        while (!minHeap.isEmpty()) {
            ans[i++] = minHeap.poll();
        }

        return ans;
    }

}
