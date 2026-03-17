// Question: https://leetcode.com/problems/design-ride-sharing-system/description/

class RideSharingSystem {
    private Queue<Integer> drivers;
    private Queue<Integer> riders;
    private boolean isTest;

    public RideSharingSystem() {
        drivers = new LinkedList<>();
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

        return riders.isEmpty() || drivers.isEmpty() ? new int[] {-1, -1} : new int[] {drivers.poll(), riders.poll()};
    }

    public void cancelRider(int riderId) {
        if (isTest) {
            System.out.println("cancel rider: " + riderId);
            display("\nbefore: ");
        }

        Queue<Integer> temp = new LinkedList<>();
        while (!riders.isEmpty()) {
            int current = riders.poll();
            if (current != riderId) {
                temp.offer(current);
            }
        }
        while (!temp.isEmpty()) {
            riders.offer(temp.poll());
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