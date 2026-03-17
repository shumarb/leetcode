// Question: https://leetcode.com/problems/design-ride-sharing-system/description/

class RideSharingSystem {
    private Queue<Integer> drivers;
    private Queue<Integer> riders;
    private boolean[] isRiderAvailable;
    private boolean isTest;

    public RideSharingSystem() {
        drivers = new LinkedList<>();
        isRiderAvailable = new boolean[1001];
        isTest = false;
        riders = new LinkedList<>();
    }

    private void display(String s) {
        System.out.println(s);
        System.out.println(" * riders: " + riders + "\n * drivers: " + drivers);
    }

    public void addRider(int riderId) {
        if (isTest) {
            System.out.println("add rider: " + riderId);
            display("\nbefore: ");
        }
        riders.add(riderId);
        isRiderAvailable[riderId] = true;
        if (isTest) {
            display("\nafter: ");
            System.out.println("---------------------------------------");
        }
    }

    public void addDriver(int driverId) {
        if (isTest) {
            System.out.println("add driver: " + driverId);
            display("\nbefore: ");
        }
        drivers.add(driverId);
        if (isTest) {
            display("\nafter: ");
            System.out.println("---------------------------------------");
        }
    }

    public int[] matchDriverWithRider() {
        if (isTest) {
            System.out.println("match driver with rider");
            display("\ncurrent:");
            System.out.println("---------------------------------------");
        }

        if (riders.isEmpty() || drivers.isEmpty()) {
            return new int[] {-1, -1};
        }

        isRiderAvailable[riders.peek()] = false;
        return new int[] {drivers.poll(), riders.poll()};
    }

    public void cancelRider(int riderId) {
        if (isTest) {
            System.out.println("cancel rider: " + riderId);
            display("\nbefore: ");
        }

        if (isRiderAvailable[riderId]) {
            isRiderAvailable[riderId] = false;
            riders.remove(riderId);
        }

        if (isTest) {
            display("\nafter: ");
            System.out.println("---------------------------------------");
        }
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */