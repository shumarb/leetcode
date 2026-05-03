// Question:

class SortVowelsByFrequency {
    public String sortVowels(String s) {
        List<Character> list = new ArrayList<>();
        PriorityQueue<Tuple> heap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.count, a.count) == 0
                        ? Integer.compare(a.index, b.index)
                        : Integer.compare(b.count, a.count)
        );
        boolean isTest = false;
        char[] letters = s.toCharArray();
        int[] count = new int[26];
        int[] firstIndex = new int[26];

        Arrays.fill(firstIndex, -1);
        for (int i = 0; i < letters.length; i++) {
            char c = letters[i];
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count[c - 'a']++;
                if (firstIndex[c - 'a'] == -1) {
                    firstIndex[c - 'a'] = i;
                }
            }
        }
        if (isTest) {
            System.out.println("before, letters: " + Arrays.toString(letters));
            System.out.println("count: " + Arrays.toString(count) + "\nfirstIndex: " + Arrays.toString(firstIndex));
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                heap.offer(new Tuple((char) ('a' + i), count[i], firstIndex[i]));
            }
        }

        // 1. Edge case: no vowels.
        if (heap.isEmpty()) {
            return s;
        }

        if (isTest) {
            System.out.println("\nheap:");
            for (Tuple e: heap) {
                System.out.println(" * [" + e.c + ", " + e.count + ", " + e.index + "]");
            }
        }

        while (!heap.isEmpty()) {
            Tuple top = heap.poll();
            for (int i = 0; i < top.count; i++) {
                list.add(top.c);
            }
        }
        if (isTest) {
            System.out.println("list: " + list);
        }

        int j = 0;
        for (int i = 0; i < letters.length; i++) {
            char c = letters[i];
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                letters[i] = list.get(j++);
            }
        }
        if (isTest) {
            System.out.println("--------------------------------------\nafter, letters: " + Arrays.toString(letters));
        }

        return new String(letters);
    }
}

class Tuple {
    char c;
    int count;
    int index;

    public Tuple(char c, int count, int index) {
        this.c = c;
        this.count = count;
        this.index = index;
    }
}
