// Question: https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/description/

class MinimumNumberOfMovesToSeatEveryone {
    private boolean isTest = false;

    public int minMovesToSeat(int[] seats, int[] students) {
        int minMoves = 0;

        countingSort(seats);
        countingSort(students);
        if (isTest) {
            System.out.println("sorted seats: " + Arrays.toString(seats));
            System.out.println("sorted students: " + Arrays.toString(students));
            System.out.println("----------------------------------------------------------------------");
        }

        for (int i = 0; i < seats.length; i++) {
            minMoves += (Math.abs(seats[i] - students[i]));
        }
        if (isTest) {
            System.out.println("minMoves: " + minMoves);
        }

        return minMoves;
    }

    private void countingSort(int[] arr) {
        int maximum = Integer.MIN_VALUE;
        for (int value: arr) {
            maximum = Math.max(maximum, value);
        }

        int[] numberFrequency = new int[maximum + 1];
        for (int value: arr) {
            numberFrequency[value]++;
        }
        if (isTest) {
            System.out.println(" * arr: " + Arrays.toString(arr) + " --> numberFrequency: " + Arrays.toString(numberFrequency));
        }

        int i = 0;
        for (int j = 0; j < numberFrequency.length; j++) {
            while (numberFrequency[j] > 0) {
                arr[i++] = j;
                numberFrequency[j]--;
            }
        }
    }
}