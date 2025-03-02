// Question: https://leetcode.com/problems/sort-characters-by-frequency/description/

class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<> ();
        boolean t = false;

        for (char x: s.toCharArray()) {
            map.put(x, 1 + map.getOrDefault(x, 0));
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        if (t) {
            System.out.println("s: " + s);
            System.out.println("map: " + map);
            System.out.println("list: " + list);
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry: list) {
            char c = entry.getKey();
            if (t) {
                System.out.println(entry);
                System.out.println("letter: " + c);
            }
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(c);
            }
        }
        if (t) {
            System.out.println("sb: " + sb.toString());
        }
        return sb.toString();
    }
}