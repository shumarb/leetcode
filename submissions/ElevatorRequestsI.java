// Question: https://leetcode.com/problems/elevator-requests-i/description/

class ElevatorRequestsI {
    public int elevatorRequests(int n, int[] requests) {
        int lastLevel = requests[0];
        int result = lastLevel;

        for (int i = 1; i < requests.length; i++) {
            int currentLevel = requests[i];
            result += Math.abs(lastLevel - currentLevel);
            lastLevel = currentLevel;
        }

        return result;
    }
}
