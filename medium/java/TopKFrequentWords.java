// Question: https://leetcode.com/problems/top-k-frequent-words/description/

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        boolean t = false;
        List<String> ans = new ArrayList<> ();
        Map<String, Integer> map = new HashMap<> ();

        for (String w: words) {
            map.put(w, 1 + map.getOrDefault(w, 0));
        }
        if (t) {
            System.out.println("map: " + map);
        }

        /**
         Given ordering: Decreasing value, Increasing key
         Arranging of elements:
         - Max heap: Prioritizes larger values first, and for equal values, prioritize smaller keys (lexicographically).
         - Min heap: Prioritizes smaller values first, and for equal values, prioritize larger keys (lexicographically).
         */
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue()
                        ? b.getKey().compareTo(a.getKey())
                        : a.getValue() - b.getValue()
        );
        for (Map.Entry<String, Integer> e: map.entrySet()) {
            minHeap.offer(e);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        if (t) {
            System.out.println("minHeap: " + minHeap);
        }

        /**
         MinHeap ordering from root to leaves in increasing order of values:
         kth, (k-1)th, (k-2)th,...2nd, 1st
         so ans is ordered as kth, (k-1)th, (k-2)th,...2nd, 1st
         hence reverse ans via collections.

         eg: [9 2 4 5 7], k = 3
         minHeap of size 3: [5, 7, 9], root is kth smallest
         add root of minHeap until empty --> ans [5 7 9]
         then reverse the order to get descending order --> [9 7 5].
         */
        int i = k - 1;
        while (!minHeap.isEmpty()) {
            ans.add(minHeap.poll().getKey());
        }
        if (t) {
            System.out.println("before reverse: " + ans);
        }
        Collections.reverse(ans);
        if (t) {
            System.out.println("after reverse: " + ans);
        }
        return ans;
    }
}