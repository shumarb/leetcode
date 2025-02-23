// Question: https://leetcode.com/problems/group-anagrams/description/

class GroupAnagrams {
    private boolean isTest = false;

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String word: strs) {
            String sortedWord = getSortedWord(word);
            updateMap(map, sortedWord, word);
        }
        if (isTest) {
            displayMap(map);
        }

        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

    private String getSortedWord(String word) {
        char[] letters = word.toCharArray();
        Arrays.sort(letters);
        return Arrays.toString(letters);
    }

    private void displayMap(Map<String, List<String>> map) {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("map: ");
        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " ---> " + entry.getValue());
        }
        System.out.println("--------------------------------------------------------------------");
    }

    private void updateMap(Map<String, List<String>> map, String sortedWord, String word) {
        if (!map.containsKey(sortedWord)) {
            List<String> anagrams = new ArrayList<>();
            anagrams.add(word);
            map.put(sortedWord, anagrams);
        } else {
            map.get(sortedWord).add(word);
        }
    }
}