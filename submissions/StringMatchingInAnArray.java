// Question: https://leetcode.com/problems/string-matching-in-an-array/description/

class StringMatchingInAnArray {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int len = words.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j && words[i].contains(words[j]) && !set.contains(words[j])) {
                    result.add(words[j]);
                    set.add(words[j]);
                }
            }
        }

        return result;
    }
}