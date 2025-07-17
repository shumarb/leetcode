// Question: https://leetcode.com/problems/odd-string-difference/description/

class OddStringDifference {
    public String oddString(String[] words) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        Map<String, String> stringKeyMap = new HashMap<>();
        String oddKey = null;
        boolean isTest = false;

        for (int i = 0; i < words.length; i++) {
            int[] differenceArray = computeDifference(words[i]);
            String key = Arrays.toString(differenceArray);
            stringKeyMap.put(words[i], key);
            frequencyMap.put(key, 1 + frequencyMap.getOrDefault(key, 0));
        }
        for (Map.Entry<String, Integer> e: frequencyMap.entrySet()) {
            if (e.getValue() == 1) {
                oddKey = e.getKey();
                break;
            }
        }
        if (isTest) {
            System.out.println("stringKeyMap: " + stringKeyMap + "\nfrequencyMap: " + frequencyMap);
            System.out.println("oddKey: " + oddKey);
        }

        for (Map.Entry<String, String> e: stringKeyMap.entrySet()) {
            if (e.getValue().equals(oddKey)) {
                if (isTest) {
                    System.out.println("return: " + e.getKey());
                }
                return e.getKey();
            }
        }

        return null;
    }

    private int[] computeDifference(String word) {
        int[] result = new int[word.length() - 1];
        int j = 0;

        for (int i = 1; i < word.length(); i++) {
            char current = word.charAt(i);
            char previous = word.charAt(i - 1);
            result[j++] = current - previous;
        }

        return result;
    }
}