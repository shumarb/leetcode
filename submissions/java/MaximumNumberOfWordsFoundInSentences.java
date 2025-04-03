// Question: https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/description/

class MaximumNumberOfWordsFoundInSentences {
    public int mostWordsFound(String[] sentences) {
        int countMostWords = 0;
        for (String sentence: sentences) {
            countMostWords = Math.max(sentence.split(" ").length, countMostWords);
        }
        return countMostWords;
    }
}