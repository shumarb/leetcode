// Question: https://leetcode.com/problems/seat-reservation-manager/description/

class SeatManager {
    private PriorityQueue<Integer> available;
    private int availableSeat;

    public SeatManager(int n) {
        available = new PriorityQueue<>();
        availableSeat = 1;
    }

    public int reserve() {
        return available.isEmpty() ? availableSeat++ : available.poll();
    }

    public void unreserve(int seatNumber) {
        available.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */