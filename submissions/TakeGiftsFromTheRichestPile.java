// Question: https://leetcode.com/problems/take-gifts-from-the-richest-pile/description/

class TakeGiftsFromTheRichestPile {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        boolean isTest = false;
        long result = 0;

        for (long number: gifts) {
            maxHeap.offer(number);
        }
        if (isTest) {
            System.out.println("gifts: " + Arrays.toString(gifts) + ", k: " + k + "\nmax heap: " + maxHeap);
        }

        while (k-- > 0) {
            maxHeap.offer((long) Math.sqrt(maxHeap.poll()));
        }
        if (isTest) {
            System.out.println("after iteration, max heap: " + maxHeap);
        }
        while (!maxHeap.isEmpty()) {
            result += maxHeap.poll();
        }

        return result;
    }
}
