// Question: https://leetcode.com/problems/remove-stones-to-minimize-the-total/description/

class RemoveStonesToMinimizeTheTotal {
    public int minStoneSum(int[] piles, int k) {
        int minStoneSum = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int pile: piles) {
            maxHeap.offer(pile);
        }
        for (int i = 0; i < k; i++) {
            int pileWithMostStones = maxHeap.poll();
            maxHeap.offer(pileWithMostStones - pileWithMostStones / 2);
        }
        while (!maxHeap.isEmpty()) {
            minStoneSum += maxHeap.poll();
        }

        return minStoneSum;
    }
}