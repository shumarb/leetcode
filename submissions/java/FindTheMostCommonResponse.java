// Question: https://leetcode.com/problems/find-the-most-common-response/description/

class FindTheMostCommonResponse {
    public String findCommonResponse(List<List<String>> responses) {
        Map<String, Integer> map = new HashMap<>();
        String result = "";
        int frequency = 0;

        for (List<String> entry: responses) {
            Set<String> set = new HashSet<>();
            for (String word: entry) {
                if (!set.contains(word)) {
                    set.add(word);
                    map.put(word, 1 + map.getOrDefault(word, 0));
                    if (map.get(word) > frequency) {
                        frequency = map.get(word);
                        result = word;
                    } else if (map.get(word) == frequency) {
                        if (word.compareTo(result) < 0) {
                            result = word;
                        }
                    }
                }
            }
        }

        return result;
    }
}