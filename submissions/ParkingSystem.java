// Question: https://leetcode.com/problems/design-parking-system/description/

class ParkingSystem {
    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1) {
            if (big == 0) {
                return false;
            } else {
                big--;
                return true;
            }

        } else if (carType == 2) {
            if (medium == 0) {
                return false;
            } else {
                medium--;
                return true;
            }

        } else {
            if (small == 0) {
                return false;
            } else {
                small--;
                return true;
            }
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */