// Question: https://leetcode.com/problems/elevator-requests-i/description/

class ElevatorRequestsI {
    public int elevatorRequests(int n, int[] requests) {
        int lastFloor = requests[0];
        int result = lastFloor;

        for (int i = 1; i < requests.length; i++) {
            int currentFloor = requests[i];
            result += Math.abs(lastFloor - currentFloor);
            lastFloor = currentFloor;
        }

        return result;
    }
}
