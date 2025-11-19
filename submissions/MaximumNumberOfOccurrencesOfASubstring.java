// Question: https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/description/

class MaximumNumberOfOccurrencesOfASubstring {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        boolean isTest = false;
        int n = s.length();
        int result = 0;

        for (int i = 0; i + minSize <= n; i++) {
            String substring = s.substring(i, i + minSize);
            if (isValid(substring, maxLetters)) {
                map.put(substring, 1 + map.getOrDefault(substring, 0));
                result = Math.max(map.get(substring), result);
            }
        }
        if (isTest) {
            System.out.println("map:");
            for (Map.Entry<String, Integer> e: map.entrySet()) {
                System.out.println(" * " + e.getKey() + " -> " + e.getValue());
            }
            System.out.println("-------------------------------------\nresult: " + result);
        }

        return result;
    }

    private boolean isValid(String check, int maxLetters) {
        boolean[] isPresent = new boolean[26];
        int countDistinct = 0;

        for (char c: check.toCharArray()) {
            if (!isPresent[c - 'a']) {
                if (++countDistinct > maxLetters) {
                    return false;
                }
                isPresent[c - 'a'] = true;
            }
        }

        return true;
    }
}