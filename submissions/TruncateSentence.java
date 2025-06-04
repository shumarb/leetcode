// Question: https://leetcode.com/problems/truncate-sentence/description/

class TruncateSentence {
    public String truncateSentence(String s, int k) {
        StringBuilder result = new StringBuilder();
        String[] words = s.split(" ");
        boolean isTest = false;

        for (int i = 0; i < k; i++) {
            result.append(words[i]);
            if (i != k - 1) {
                result.append(' ');
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\nk: " + k + "\nresult: " + result.toString());
        }

        return result.toString();
    }
}