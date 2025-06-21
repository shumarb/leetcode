// Question: https://leetcode.com/problems/rearrange-words-in-a-sentence/description/

class RearrangeWordsInASentence {
    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder();
        boolean isTest = false;

        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        if (isTest) {
            System.out.println("text: " + text);
            System.out.println("sorted words: " + Arrays.toString(words));
            System.out.println("----------------------------------------------");
        }

        char[] letters = words[0].toCharArray();
        letters[0] = Character.toUpperCase(letters[0]);
        result.append(new String(letters) + " ");
        for (int i = 1; i < words.length - 1; i++) {
            result.append(words[i].toLowerCase() + " ");
        }
        result.append(words[words.length - 1].toLowerCase());
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