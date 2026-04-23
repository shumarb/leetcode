// Question:

class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        boolean isTest = false;
        int[] timeline = new int[1001];
        int end = Integer.MIN_VALUE;
        int filledSeats = 0;
        int start = Integer.MAX_VALUE;

        for (int[] trip: trips) {
            end = Math.max(end, trip[2]);
            start = Math.min(start, trip[1]);

            // 1. Keep track of total passengers entering/exiting in each time of entire journey.
            timeline[trip[1]] += trip[0];
            timeline[trip[2]] -= trip[0];
        }
        if (isTest) {
            System.out.println("time: [" + start + ", " + end + "]");
            System.out.println("-----------------------------------\ntrips:");
            for (int[] trip: trips) {
                System.out.println(Arrays.toString(trip));
            }
            System.out.println("-----------------------------------\ntimeline: " + Arrays.toString(Arrays.copyOfRange(timeline, 0, end + 1)));
        }

        // 2. Add number of seats used (if any) for each time to filledSeats,
        // returning false if filledSeats exceeds capacity.
        for (int i = start; i <= end; i++) {
            filledSeats += timeline[i];
            if (filledSeats > capacity) {
                if (isTest) {
                    System.out.println(" * overflow @ time " + i + " | filledSeats: " + filledSeats + ", capacity: " + capacity);
                }
                return false;
            }
        }

        return true;
    }
}
