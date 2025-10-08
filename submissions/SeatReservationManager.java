// Question: https://leetcode.com/problems/seat-reservation-manager/description/

class SeatManager {
    private PriorityQueue<Integer> available;
    private boolean[] isReserved;

    public SeatManager(int n) {
        available = new PriorityQueue<>();
        isReserved = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            available.offer(i);
        }
    }

    public int reserve() {
        int top = available.poll();
        isReserved[top] = true;
        return top;
    }

    public void unreserve(int seatNumber) {
        isReserved[seatNumber] = false;
        available.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */