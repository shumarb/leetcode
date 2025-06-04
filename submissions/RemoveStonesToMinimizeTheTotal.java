// Question: https://leetcode.com/problems/remove-stones-to-minimize-the-total/description/

class RemoveStonesToMinimizeTheTotal {
    public int minStoneSum(int[] piles, int k) {
        int sum = 0;
        boolean isTest = true;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int pile: piles) {
            maxHeap.offer(pile);
            sum += pile;
        }

        while (k-- > 0) {
            int maximum = maxHeap.poll();
            int removal = maximum / 2;
            sum -= removal;
            maxHeap.offer(maximum - removal);
        }

        return sum;
    }
}