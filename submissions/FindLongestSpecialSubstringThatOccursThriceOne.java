// Question: https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/description/

class FindLongestSpecialSubstringThatOccursThriceOne {
    public int maximumLength(String s) {
        Map<String, Integer> map = new HashMap<>();
        boolean isTest = false;
        int maximumLength = -1;
        int len = s.length();
        int windowSize = 1;

        while (windowSize <= len) {
            if (isTest) {
                System.out.println("---------------------------------------");
                System.out.println("windowSize: " + windowSize);
            }
            for (int i = 0; i <= len - windowSize; i++) {
                String window = s.substring(i, i + windowSize);
                if (isSpecial(window)) {
                    if (isTest) {
                        System.out.println(" * special window: " + window);
                    }
                    map.put(window, 1 + map.getOrDefault(window, 0));
                    if (map.get(window) >= 3) {
                        maximumLength = Math.max(maximumLength, window.length());
                    }
                }
            }
            windowSize++;
        }
        if (isTest) {
            System.out.println("---------------------------------------");
            System.out.println("map: " + map);
            System.out.println("maximumLength: " + maximumLength);
        }

        return maximumLength;
    }

    private boolean isSpecial(String window) {
        boolean[] isPresent = new boolean[26];
        int countDistinct = 0;
        for (char c: window.toCharArray()) {
            if (!isPresent[c - 'a']) {
                countDistinct++;
            }
            isPresent[c - 'a'] = true;
            if (countDistinct > 1) {
                return false;
            }
        }
        return true;
    }
}