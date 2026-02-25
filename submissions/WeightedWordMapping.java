// Question: https://leetcode.com/problems/weighted-word-mapping/description/

class WeightedWordMapping {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;

        for (String w: words) {
            int wordWeight = 0;

            for (char c: w.toCharArray()) {
                wordWeight += weights[c - 'a'];
            }
            int value = wordWeight % 26;
            char letter = (char) ('z' - value);
            result.append(letter);
            if (isTest) {
                System.out.println("w: " + w + " -> weight: " + wordWeight + " | value: " + value + " -> letter: " + letter);
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------\nresult: " + result);
        }

        return result.toString();
    }
}