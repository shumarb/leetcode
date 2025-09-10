// Question: https://leetcode.com/problems/calculate-delayed-arrival-time/description/

class CalculateDelayedArrivalTime {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}