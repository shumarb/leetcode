// Question: https://leetcode.com/problems/calculate-delayed-arrival-time/description/

class CalculateDelayedArrivalTime {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        while (delayedTime > 0) {
            arrivalTime++;
            if (arrivalTime == 24) {
                arrivalTime = 0;
            }
            delayedTime--;
        }
        if (arrivalTime == 24) {
            arrivalTime = 0;
        }

        return arrivalTime;
    }
}