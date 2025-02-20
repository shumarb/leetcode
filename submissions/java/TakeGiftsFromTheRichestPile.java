// Question: https://leetcode.com/problems/take-gifts-from-the-richest-pile/description/

class TakeGiftsFromTheRichestPile {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long result = 0;
        boolean isTest = false;

        for (int number: gifts) {
            maxHeap.offer((long) number);
        }
        if (isTest) {
            System.out.println("gifts: " + Arrays.toString(gifts) + ", k: " + k + "\nmax heap: " + maxHeap);
        }

        for (int i = 0; i < k; i++) {
            long topGift = maxHeap.poll();
            maxHeap.offer((long) Math.sqrt(topGift));
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