// Question: https://leetcode.com/problems/rearrange-words-in-a-sentence/description/

class RearrangeWordsInASentence {
    public String arrangeWords(String text) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.word.length(), b.word.length()) == 0
                        ? Integer.compare(a.index, b.index)
                        : Integer.compare(a.word.length(), b.word.length())
        );
        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder();
        boolean isTest = false;

        for (int i = 0; i < words.length; i++) {
            minHeap.offer(new Pair(words[i], i));
        }
        if (isTest) {
            System.out.println("text: " + text);
            System.out.println("words: " + Arrays.toString(words));
            System.out.println("----------------------------------------------");
            display(minHeap);
            System.out.println("----------------------------------------------");
        }

        Pair top = minHeap.poll();
        char[] letters = top.word.toCharArray();
        letters[0] = Character.toUpperCase(letters[0]);
        result.append(new String(letters) + " ");
        while (minHeap.size() > 1) {
            top = minHeap.poll();
            result.append(top.word.toLowerCase() + " ");
        }
        top = minHeap.poll();
        result.append(top.word.toLowerCase());
        if (isTest) {
            System.out.println("result: " + result.toString());
        }

        return result.toString();
    }

    private void display(PriorityQueue<Pair> minHeap) {
        System.out.println("min heap:");
        for (Pair e: minHeap) {
            System.out.println(" * " + e.word + " -> " + e.index);
        }
    }
}

class Pair {
    String word;
    int index;

    public Pair(String word, int index) {
        this.word = word;
        this.index = index;
    }
}