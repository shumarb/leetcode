// Question: https://leetcode.com/problems/rearrange-words-in-a-sentence/description/

class RearrangeWordsInASentence {
    public String arrangeWords(String text) {
        List<String> words = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        boolean isTest = false;

        for (String word: text.split(" ")) {
            words.add(word);
        }
        Collections.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        if (isTest) {
            System.out.println("text: " + text);
            System.out.println("sorted words: " + words);
            System.out.println("----------------------------------------------");
        }

        char[] letters = words.get(0).toCharArray();
        letters[0] = Character.toUpperCase(letters[0]);
        result.append(new String(letters) + " ");
        for (int i = 1; i < words.size() - 1; i++) {
            result.append(words.get(i).toLowerCase() + " ");
        }
        result.append(words.get(words.size() - 1).toLowerCase());
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