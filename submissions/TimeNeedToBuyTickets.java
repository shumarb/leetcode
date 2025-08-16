// Question: https://leetcode.com/problems/time-needed-to-buy-tickets/description/

class TimeNeedToBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int timeRequiredToBuy = 0;

        for (int i = 0; i < tickets.length; i++) {
            /**
             * 1. For each person:Calculates the total time required for the person at index k to buy all their tickets.
             *    - For persons on indices [0, k], they can buy up to tickets[k] tickets because
                    k-th person must finish buying all their tickets first.
             *    - For persons after index k, they can buy at most (tickets[k] - 1) tickets
                    because once k-person finishes, the buying stops the k-person k.
             */
            if (i <= k) {
                timeRequiredToBuy += Math.min(tickets[i], tickets[k]);
            } else {
                timeRequiredToBuy += Math.min(tickets[i], tickets[k] - 1);
            }
        }

        return timeRequiredToBuy;
    }
}