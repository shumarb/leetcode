// Question: https://leetcode.com/problems/weighted-word-mapping/description/

class WeightedWordMapping {
    public String mapWordWeights(String[] words, int[] weights) {
        boolean isTest = false;
        char[] result = new char[words.length];
        int index = 0;

        for (String word: words) {
            int sum = 0;
            for (char letter: word.toCharArray()) {
                sum += weights[letter - 'a'];
            }
            result[index++] = (char) ('z' - (sum % 26));
        }
        if (isTest) {
            System.out.println("result: " + Arrays.toString(result));
        }

        return new String(result);
    }
}
