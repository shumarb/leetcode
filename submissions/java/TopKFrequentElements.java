// Question: https://leetcode.com/problems/top-k-frequent-elements/description/

class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        boolean test = false;
        Map<Integer, Integer> map = new HashMap<> ();

        for (int x: nums) {
            map.put(x, 1 + map.getOrDefault(x, 0));
        }
        if (test) {
            System.out.println("map: " + map);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<> (
                (a, b) -> a.getValue() - b.getValue()
        );
        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            minHeap.offer(e);
            if (minHeap.size() > k) {
                if (test) {
                    System.out.println("before removal - minHeap: " + minHeap);
                }
                minHeap.poll();
                if (test) {
                    System.out.println("after removal - minHeap: " + minHeap);
                }
            }
        }
        if (test) {
            System.out.println("after iteration of hashmap entries, removal - minHeap: " + minHeap);
        }

        int j = k - 1;
        while (!minHeap.isEmpty()) {
            ans[j--] = minHeap.poll().getKey();
        }
        if (test) {
            System.out.println("ans: " + Arrays.toString(ans));
        }

        return ans;
    }
}
