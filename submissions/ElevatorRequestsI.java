// Question: https://leetcode.com/problems/elevator-requests-i/description/

class ElevatorRequestsI {
    public int elevatorRequests(int n, int[] requests) {
        int current = 0;
        int result = 0;

        for (int floor: requests) {
            result += Math.abs(floor - current);
            current = floor;
        }

        return result;
    }
}
