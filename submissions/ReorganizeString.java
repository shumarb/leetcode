// Question: https://leetcode.com/problems/reorganize-string/description/

class ReorganizeString {
    public String reorganizeString(String s) {
        PriorityQueue<Character> maxHeap;
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        int[] frequency = new int[26];

        for (char letter: s.toCharArray()) {
            frequency[letter - 'a']++;
        }
        maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(frequency[b - 'a'], frequency[a - 'a'])
        );
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                maxHeap.offer((char) ('a' + i));
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\nbefore, frequency: " + Arrays.toString(frequency) + "\nmaxHeap: " + maxHeap);
        }

        while (maxHeap.size() > 1) {
            char first = maxHeap.poll();
            char second = maxHeap.poll();

            result.append(first);
            result.append(second);

            if (--frequency[first - 'a'] > 0) {
                maxHeap.offer(first);
            }
            if (--frequency[second - 'a'] > 0) {
                maxHeap.offer(second);
            }
        }
        while (!maxHeap.isEmpty()) {
            char letter = maxHeap.poll();
            if (frequency[letter - 'a'] > 1) {
                return "";
            }
            result.append(letter);
        }
        if (isTest) {
            System.out.println("after, frequency: " + Arrays.toString(frequency) + "\nmaxHeap: " + maxHeap + "\nresult: " + result);
        }

        return result.toString();
    }
}