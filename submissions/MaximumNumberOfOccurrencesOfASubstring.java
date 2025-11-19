// Question: https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/description/

class MaximumNumberOfOccurrencesOfASubstring {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        boolean isTest = false;
        int n = s.length();
        int result = 0;
        int windowSize = minSize;

        while (windowSize <= maxSize) {
            if (isTest) {
                System.out.println("-------------------------------------------");
                System.out.println("windowSize: " + windowSize);
            }
            for (int i = 0; i <= n - windowSize; i++) {
                String substring = s.substring(i, i + windowSize);
                boolean[] isPresent = new boolean[26];
                boolean isValid = true;
                int countDistinctLetters = 0;

                for (char c: substring.toCharArray()) {
                    if (!isPresent[c - 'a']) {
                        isPresent[c - 'a'] = true;
                        countDistinctLetters++;
                        if (countDistinctLetters > maxLetters) {
                            isValid = false;
                            break;
                        }
                    }
                }
                if (isValid) {
                    if (isTest) {
                        System.out.println("i: " + i + " -> valid substring: " + substring);
                    }
                    map.put(substring, 1 + map.getOrDefault(substring, 0));
                }
            }
            windowSize++;
        }

        for (Map.Entry<String, Integer> e: map.entrySet()) {
            result = Math.max(e.getValue(), result);
        }
        if (isTest) {
            System.out.println("-------------------------------------------");
            System.out.println("map:");
            for (Map.Entry<String, Integer> e: map.entrySet()) {
                System.out.println(" * " + e.getKey() + " -> " + e.getValue());
            }
            System.out.println("-------------------------------------------\nresult: " + result);
        }

        return result;
    }
}