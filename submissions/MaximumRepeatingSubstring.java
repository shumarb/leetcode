// Question: https://leetcode.com/problems/maximum-repeating-substring/description/

class MaximumRepeatingSubstring {
    public int maxRepeating(String sequence, String word) {
        StringBuilder updatedWord = new StringBuilder();
        int count = 0;
        updatedWord.append(word);

        while (sequence.contains(updatedWord.toString())) {
            count++;
            updatedWord.append(word);
        }

        return count;
    }
}