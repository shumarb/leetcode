// Question: https://leetcode.com/problems/sort-vowels-in-a-string/description/

class SortVowelsInAString {
    public String sortVowels(String s) {
        PriorityQueue<Character> minHeap = new PriorityQueue<>();
        boolean isTest = false;
        char[] letters = s.toCharArray();

        for (char letter: letters) {
            if (isVowel(letter)) {
                minHeap.offer(letter);
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\nletters: " + Arrays.toString(letters) + "\nminHeap: " + minHeap);
        }

        for (int i = 0; i < letters.length; i++) {
            if (isVowel(letters[i])) {
                letters[i] = minHeap.poll();
            }
        }

        return new String(letters);
    }

    private boolean isVowel(char letter) {
        return letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U' ||
                letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u';
    }
}