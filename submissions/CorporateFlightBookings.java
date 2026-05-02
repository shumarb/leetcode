// Question: https://leetcode.com/problems/corporate-flight-bookings/description/

class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        boolean isTest = false;
        int[] result = new int[n];

        for (int[] booking: bookings) {
            for (int i = booking[0] - 1; i <= booking[1] - 1; i++) {
                result[i] += booking[2];
            }
        }
        if (isTest) {
            System.out.println("\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}
