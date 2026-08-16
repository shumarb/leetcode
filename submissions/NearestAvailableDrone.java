// Question: https://leetcode.com/problems/nearest-available-drone/description/

class NearestAvailableDrone {
    public int nearestDrone(int[][] drones, int[] target) {
        boolean isTest = false;
        int minimumManhattanDistance = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;

        if (isTest) {
            System.out.println("target: " + Arrays.toString(target) + "\n--------------------------------------------------");
        }
        for (int i = 0; i < drones.length; i++) {
            int[] drone = drones[i];
            int manhattanDistance = Math.abs(drone[0] - target[0]) + Math.abs(drone[1] - target[1]);

            if (isTest) {
                System.out.println(" * drone: " + Arrays.toString(drone) + " -> manhattan distance: " + manhattanDistance);
            }

            if (manhattanDistance <= drone[2] && manhattanDistance < minimumManhattanDistance) {
                minimumManhattanDistance = manhattanDistance;
                result = i;
            }
        }
        if (isTest) {
            System.out.println("--------------------------------------------------\nminimumManhattanDistance: " + minimumManhattanDistance + "\nresult: " + result);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
