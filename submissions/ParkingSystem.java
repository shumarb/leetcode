// Question: https://leetcode.com/problems/design-parking-system/description/

class ParkingSystem {
    private int[] lots;

    public ParkingSystem(int big, int medium, int small) {
        lots = new int[3];
        lots[0] = big;
        lots[1] = medium;
        lots[2] = small;
    }

    public boolean addCar(int carType) {
        if (lots[carType - 1] > 0) {
            lots[carType - 1]--;
            return true;
        }

        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */