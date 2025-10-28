// Question: https://leetcode.com/problems/number-of-matching-subsequences/description/

class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String s, String[] words) {
        List<Queue<String>> queue = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < 26; i++) {
            queue.add(new LinkedList<>());
        }
        for (String word: words) {
            queue.get(word.charAt(0) - 'a').offer(word);
        }

        for (char c: s.toCharArray()) {
            Queue<String> current = queue.get(c - 'a');
            int size = current.size();

            for (int i = 0; i < size; i++) {
                String word = current.poll();
                if (word.length() == 1) {
                    count++;
                } else {
                    queue.get(word.charAt(1) - 'a').offer(word.substring(1));
                }
            }
        }

        return count;
    }
}
