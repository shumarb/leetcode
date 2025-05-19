// Question: https://leetcode.com/problems/count-days-without-meetings/description/

class CountDaysWithoutMeetings {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        boolean isTest = false;
        int count = 0;

        /**
         1.  Set current meeting as first meeting,
             and count number of days before start day of first meeting.
             Example: First meeting: [2, 8] means day 1 is free
             (no day 0 due to 1-based counting),
             so number of free days = start day - 1.
         */
        int[] current = meetings[0];
        count += current[0] - 1;
        list.add(meetings[0]);
        for (int i = 1; i < meetings.length; i++) {
            int[] incoming = meetings[i];
            if (incoming[0] <= current[1]) {
                current[1] = Math.max(incoming[1], current[1]);
            } else {
                list.add(incoming);
                current = incoming;
            }
        }

        if (isTest) {
            System.out.println("days: " + days + "\nsorted meetings (ascending start time):");
            for (int[] row: meetings) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("\nlist:");
            for (int[] row: list) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("-------------------------------");
        }

        /**
         2.  Count number of free days between 2 adjacent days up from first to last day,
             then count number of free days between last day and total number of days
             an employee is available for work.

             For first calculation, reduce value by 1 to avoid overlapping days.
         */
        int len = list.size();
        for (int i = 0; i < len - 1; i++) {
            count += (list.get(i + 1)[0] - list.get(i)[1] - 1);
        }
        count += (days - list.get(len - 1)[1]);
        if (isTest) {
            System.out.println("count: " + count);
        }

        return count;
    }
}