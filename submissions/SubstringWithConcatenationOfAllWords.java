// Question: https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> concatenatedWordsMap = new HashMap<>();
        boolean isTest = false;
        int k = 0;
        int n = s.length();
        int wordLength = words[0].length();

        for (String word: words) {
            k += word.length();
            concatenatedWordsMap.put(word, 1 + concatenatedWordsMap.getOrDefault(word, 0));
        }
        if (isTest) {
            System.out.println("s: " + s + "\nwords: " + Arrays.toString(words) + "\nk: " + k + "\nn: " + n + "\nconcatenatedWordsMap: " + concatenatedWordsMap);
        }
        if (k > n) {
            return result;
        }

        for (int i = 0; i <= n - k; i++) {
            Map<String, Integer> tokenMap = new HashMap<>();
            String token = s.substring(i, i + k);

            for (int j = 0; j < token.length(); j += wordLength) {
                String part = token.substring(j, j + wordLength);
                tokenMap.put(part, 1 + tokenMap.getOrDefault(part, 0));
            }
            if (isTest) {
                System.out.println("------------------------------------------------------------------------");
                System.out.print(" * [" + i + ", " + (i + k - 1) + "] | token: " + token + " | tokenMap: " + tokenMap);
            }

            if (concatenatedWordsMap.equals(tokenMap)) {
                if (isTest) {
                    System.out.println(" -> valid");
                }
                result.add(i);

            } else {
                if (isTest) {
                    System.out.println();
                }
            }
        }
        if (isTest) {
            System.out.println("------------------------------------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
