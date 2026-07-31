// Question: https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/description/

class MininumNumberOfPushesToTypeWordII {
    public int minimumPushes(String word) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[1], a[1])
        );
        boolean isTest = false;
        int[] count = new int[26];
        int countPresses = 1;
        int countUniqueLetters = 0;
        long result = 0;

        for (char c: word.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                maxHeap.offer(new int[] {i, count[i]});
            }
        }
        if (isTest) {
            System.out.println("maxHeap:");
            for (int[] e: maxHeap) {
                System.out.println(" * " + (char) ('a' + e[0]) + ": " + e[1]);
            }
            System.out.println("----------------------------------------------------------------------");
        }
        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            char letter = (char) ('a' + top[0]);
            int totalPresses = top[1] * countPresses;

            if (isTest) {
                System.out.println(" * " + letter + ", frequency: " + top[1] + ", presses per letter: " + countPresses + ", total presses: " + totalPresses);
            }
            result += totalPresses;
            if (++countUniqueLetters == 8) {
                countPresses++;
                countUniqueLetters = 0;
            }
        }
        if (isTest) {
            System.out.println("----------------------------------------------------------------------\nresult: " + result);
        }

        return (int) result;
    }
}
