// Question: https://leetcode.com/problems/top-k-frequent-words/description/

class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        boolean isTest = false;
        List<String> result = new ArrayList<> ();
        Map<String, Integer> map = new HashMap<> ();

        for (String word: words) {
            map.put(word, 1 + map.getOrDefault(word, 0));
        }
        if (isTest) {
            System.out.println("map: " + map);
        }

        /**
         1.  Given ordering: Decreasing value, Increasing key.
             Arranging of elements:
             - Max heap: Prioritizes larger values first, and for equal values, prioritize lexigraphically smaller keys.
             - Min heap: Prioritizes smaller values first, and for equal values, prioritize lexigraphically larger keys.
         */
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.getValue(), b.getValue()) == 0
                        ? b.getKey().compareTo(a.getKey())
                        : Integer.compare(a.getValue(), b.getValue())
        );
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        if (isTest) {
            System.out.println("minHeap: " + minHeap);
        }

        /**
         2.  MinHeap ordering from root to leaves in increasing order of values:
             kth, (k-1)th, (k-2)th,...2nd, 1st
             so ans is ordered as kth, (k-1)th, (k-2)th,...2nd, 1st
             hence reverse ans via collections.

             eg: [9 2 4 5 7], k = 3
             minHeap of size 3: [5, 7, 9], root is kth smallest
             add root of minHeap until empty --> ans [5 7 9]
             then reverse the order to get descending order --> [9 7 5].
         */
        while (!minHeap.isEmpty()) {
            result.add(0, minHeap.poll().getKey());
        }

        return result;
    }
}