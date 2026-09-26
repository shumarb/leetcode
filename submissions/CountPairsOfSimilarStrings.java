// Question: https://leetcode.com/problems/count-pairs-of-similar-strings/description/

class CountPairsOfSimilarStrings {
    public int similarPairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        boolean isTest = false;
        int result = 0;

        for (String w: words) {
            boolean[] isPresent = new boolean[26];
            for (char c: w.toCharArray()) {
                isPresent[c - 'a'] = true;
            }

            map.merge(Arrays.toString(isPresent), 1, Integer::sum);
        }

        for (String key: map.keySet()) {
            int value = map.get(key);
            result += (value * (value - 1)) / 2;
        }
        if (isTest) {
            System.out.println("words: " + Arrays.toString(words) + "\nmap:");
            for (String key: map.keySet()) {
                System.out.println(" * " + key + ": " + map.get(key));
            }
            System.out.println("--------------------------\nresult: " + result);
        }

        return result;
    }
}
