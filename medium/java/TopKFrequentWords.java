// Question: https://leetcode.com/problems/top-k-frequent-words/description/

class TopKFrequentWords {
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

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> {
            if (b.getValue() != a.getValue()) {
                return b.getValue() - a.getValue();
            }
            return a.getKey().compareTo(b.getKey());
        });
        if (t) {
            System.out.println("list: " + list);
        }

        for (int i = 0; i < k; i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            ans.add(entry.getKey());
        }
        if (t) {
            System.out.println(ans);
        }

        return ans;
    }
}