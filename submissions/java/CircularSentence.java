// Question: https://leetcode.com/problems/circular-sentence/description/

class CircularSentence {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        boolean isTest = false;
        int len = words.length;

        if (isTest) {
            System.out.println("sentence: " + sentence + "\nwords: " + Arrays.toString(words));
        }

        String first = words[0];
        String last = words[len - 1];
        if (last.charAt(last.length() - 1) != first.charAt(0)) {
            return false;
        }
        for (int i = 0; i < len - 1; i++) {
            String current = words[i];
            String next = words[i + 1];
            if (current.charAt(current.length() - 1) != next.charAt(0)) {
                return false;
            }
        }

        return true;
    }
}