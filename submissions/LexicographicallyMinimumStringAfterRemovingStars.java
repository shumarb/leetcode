// Question: https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars/description/

class LexicographicallyMinimumStringAfterRemovingStars {
    public String clearStars(String s) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
                (a, b) -> Character.compare(a.letter, b.letter) == 0
                        ? Integer.compare(b.index, a.index)
                        : Character.compare(a.letter, b.letter)
        );
        StringBuilder result = new StringBuilder();
        boolean isTest = false;

        for (int i = 0; i < s.length(); i++) {
            char part = s.charAt(i);
            if (part == '*') {
                if (!minHeap.isEmpty()) {
                    minHeap.poll();
                }
            } else {
                minHeap.offer(new Pair(part, i));
            }
        }
        if (isTest) {
            System.out.println("minHeap: ");
            for (Pair entry: minHeap) {
                System.out.println(entry.letter + " -> " + entry.index);
            }
        }
        if (minHeap.isEmpty()) {
            return "";
        }

        Pair[] arr = new Pair[minHeap.size()];
        int i = 0;
        while (!minHeap.isEmpty()) {
            arr[i++] = minHeap.poll();
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a.index, b.index));
        for (Pair entry: arr) {
            result.append(entry.letter);
        }
        if (isTest) {
            System.out.println("s: " + s + "\nresult: " + result.toString());
        }

        return result.toString();
    }
}

class Pair {
    char letter;
    int index;

    public Pair(char letter, int index) {
        this.letter = letter;
        this.index = index;
    }
}