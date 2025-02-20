// Question: https://leetcode.com/problems/sort-characters-by-frequency/description/

class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<> ();
        for (char letter: s.toCharArray()) {
            map.put(letter, 1 + map.getOrDefault(letter, 0));
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> e2.getValue() - e1.getValue());

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry: list) {
            char c = entry.getKey();
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}