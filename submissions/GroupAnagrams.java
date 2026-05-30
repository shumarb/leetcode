// Question: https://leetcode.com/problems/group-anagrams/description/

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) {
            return List.of(List.of(strs));
        }

        Map<String, List<String>> map = new HashMap<>();
        boolean isTest = false;

        for (String s: strs) {
            char[] sortedLetters = s.toCharArray();
            Arrays.sort(sortedLetters);
            if (isTest) {
                System.out.println("s: " + s + " -> sortedLetters: " + Arrays.toString(sortedLetters));
            }

            String key = String.valueOf(sortedLetters);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        if (isTest) {
            System.out.println("----------------------------------------\nmap:");
            for (String key: map.keySet()) {
                System.out.println(" * " + key + ": " + map.get(key));
            }
        }

        return new ArrayList<>(map.values());
    }
}
