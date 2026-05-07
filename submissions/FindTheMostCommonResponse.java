// Question: https://leetcode.com/problems/find-the-most-common-response/description/

class FindTheMostCommonResponse {
    public String findCommonResponse(List<List<String>> responses) {
        Map<String, Integer> map = new HashMap<>();
        String result = "";
        int frequency = 0;

        for (List<String> entry: responses) {
            for (String word: new HashSet<>(entry)) {
                map.put(word, 1 + map.getOrDefault(word, 0));
                if (map.get(word) > frequency) {
                    frequency = map.get(word);
                    result = word;
                } else if (map.get(word) == frequency && word.compareTo(result) < 0) {
                    result = word;
                }
            }
        }

        return result;
    }
}
