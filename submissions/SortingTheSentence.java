// Question: https://leetcode.com/problems/sorting-the-sentence/description/?envType=problem-list-v2&envId=sorting

class SortingTheSentence {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] sortedWords = new String[words.length];
        boolean isTest = false;

        for (String word: words) {
            int index = Character.getNumericValue(word.charAt(word.length() - 1)) - 1;
            sortedWords[index] = word.substring(0, word.length() - 1);
        }
        if (isTest) {
            System.out.println("s: " + s + "\nwords: " + Arrays.toString(words) + "\nsorted words: " + Arrays.toString(sortedWords));
        }

        return String.join(" ", sortedWords);
    }
}