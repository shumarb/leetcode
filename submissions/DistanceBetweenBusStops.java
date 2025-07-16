// Question: https://leetcode.com/problems/distance-between-bus-stops/description/

class DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        boolean isTest = false;
        int clockwiseDistance = 0;
        int n = distance.length;
        int totalDistance = 0;

        // 1. Edge case: start at destination.
        if (start == destination) {
            return 0;
        }

        // 2. Computation is in clockwise order.
        if (start > destination) {
            int temp = destination;
            destination = start;
            start = temp;
        }

        for (int i = 0; i < n; i++) {
            totalDistance += distance[i];
            if (i >= start && i < destination) {
                clockwiseDistance += distance[i];
            }
        }
        if (isTest) {
            System.out.println("distance: " + Arrays.toString(distance));
            System.out.println("start: " + start + "\ndestination: " + destination);
            System.out.println("------------------------------------------------------------");
            System.out.println("antiClockwiseDistance: " + (totalDistance - clockwiseDistance) + "\nclockwiseDistance: " + clockwiseDistance);
            System.out.println("result: " + Math.min((totalDistance - clockwiseDistance), clockwiseDistance));
        }

        return Math.min((totalDistance - clockwiseDistance), clockwiseDistance);
    }
}