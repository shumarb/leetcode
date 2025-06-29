// Question: https://leetcode.com/problems/group-anagrams/description/

class GroupAnagrams {
    private boolean isTest = false;

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String word: strs) {
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }
        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            result.add(entry.getValue());
        }
        if (isTest) {
            System.out.println("--------------------------------------------------------------------");
            System.out.println("map: ");
            for (Map.Entry<String, List<String>> entry: map.entrySet()) {
                System.out.println(entry.getKey() + " ---> " + entry.getValue());
            }
            System.out.println("--------------------------------------------------------------------");
            System.out.println("result:");
            for (List<String> entry: result) {
                System.out.println(entry);
            }
        }

        return result;
    }
}