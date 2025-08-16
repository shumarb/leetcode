// Question: https://leetcode.com/problems/time-needed-to-buy-tickets/description/

class TimeNeedToBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int timeRequiredToBuy = 0;

        while (tickets[k] > 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] > 0) {
                    tickets[i]--;
                    timeRequiredToBuy++;
                }

                if (tickets[k] == 0) {
                    break;
                }
            }
        }

        return timeRequiredToBuy;
    }
}