// Question: https://leetcode.com/problems/count-days-spent-together/description/

class CountDaysSpentTogether {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String earliestLeave = leaveAlice;
        String latestArrive = arriveAlice;
        boolean isTest = false;
        int[] daysPerMonth = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int result = 0;

        if (arriveBob.compareTo(latestArrive) > 0) {
            latestArrive = arriveBob;
        }
        if (leaveBob.compareTo(earliestLeave) < 0) {
            earliestLeave = leaveBob;
        }
        if (isTest) {
            System.out.println("latestArrive: " + latestArrive + ", earliestLeave: " + earliestLeave);
        }

        if (earliestLeave.compareTo(latestArrive) < 0) {
            return 0;

        } else if (earliestLeave.compareTo(latestArrive) == 0) {
            return 1;
        }

        int arriveDay = getValue(latestArrive.substring(3));
        int arriveMonth = getValue(latestArrive.substring(0, 2));
        int leaveDay = getValue(earliestLeave.substring(3));
        int leaveMonth = getValue(earliestLeave.substring(0, 2));

        if (isTest) {
            System.out.println("\ndaysPerMonth: " + Arrays.toString(daysPerMonth) + "\narriveDay: " + arriveDay + "\narriveMonth: " + arriveMonth + "\nleaveDay: " + leaveDay + "\nleaveMonth: " + leaveMonth);
        }

        if (arriveMonth == leaveMonth) {
            return leaveDay - arriveDay + 1;
        }

        result += daysPerMonth[arriveMonth - 1] - arriveDay + 1;
        for (int i = arriveMonth + 1; i <= leaveMonth - 1; i++) {
            result += daysPerMonth[i - 1];
        }
        result += leaveDay;

        return result;
    }

    private int getValue(String s) {
        int result = 0;

        for (char c: s.toCharArray()) {
            result *= 10;
            result += (c - '0');
        }

        return result;
    }
}
