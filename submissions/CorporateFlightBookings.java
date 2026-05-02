// Question: https://leetcode.com/problems/corporate-flight-bookings/description/

class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        boolean isTest = false;
        int[] result = new int[n];

        for (int[] booking: bookings) {
            int end = booking[1] - 1;
            int seats = booking[2];
            int start = booking[0] - 1;

            result[start] += seats;
            if (end + 1 < n) {
                result[end + 1] -= seats;
            }
        }
        if (isTest) {
            System.out.println("before, result: " + Arrays.toString(result));
        }

        for (int i = 1; i < n; i++) {
            result[i] += result[i - 1];
        }
        if (isTest) {
            System.out.println("-----------------------\nafter, result: " + Arrays.toString(result));
        }

        return result;
    }
}
