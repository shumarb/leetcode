// Question: https://leetcode.com/problems/determine-if-two-strings-are-close/description/

class DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;

        } else if (word1.equals(word2)) {
            return true;
        }

        Map<Character, Integer> count1 = getCount(word1);
        Map<Character, Integer> count2 = getCount(word2);
        Map<Integer, Integer> map1 = getCountFrequency(count1);
        Map<Integer, Integer> map2 = getCountFrequency(count2);
        boolean isTest = false;

        for (Character key: count1.keySet()) {
            if (!count2.containsKey(key)) {
                return false;
            }
        }
        for (Character key: count2.keySet()) {
            if (!count1.containsKey(key)) {
                return false;
            }
        }
        if (isTest) {
            System.out.println("word1: " + word1 + ", count1: " + count1 + ", map1: " + map1);
            System.out.println("word2: " + word2 + ", count2: " + count2 + ", map2: " + map2);
        }

        return map1.equals(map2);
    }

    private Map<Character, Integer> getCount(String w) {
        Map<Character, Integer> result = new HashMap<>();

        for (char c: w.toCharArray()) {
            result.put(c, 1 + result.getOrDefault(c, 0));
        }

        return result;
    }

    private Map<Integer, Integer> getCountFrequency(Map<Character, Integer> map) {
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();

        for (Integer v: map.values()) {
            result.put(v, 1 + result.getOrDefault(v, 0));
        }

        return result;
    }
}
