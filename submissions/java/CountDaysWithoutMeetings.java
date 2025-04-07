// Question: https://leetcode.com/problems/count-days-without-meetings/description/

class CountDaysWithoutMeetings {
    public int countDays(int days, int[][] meetings) {
        boolean isTest = false;
        int countDays = days;
        int previousEnd = -1;

        // 1. Sort meetings in ascending order of start times.
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        if (isTest) {
            System.out.println("days: " + days + "\nsorted meetings:");
            for (int[] row: meetings) {
                System.out.println(" * " + Arrays.toString(row));
            }
        }

        for (int[] meeting: meetings) {
            int start = meeting[0];
            int end = meeting[1];

            /**
             2.  If current meeting starts after previous one ends,
             reduce available days by number of days that the meeting covers.
             */
            if (start > previousEnd) {
                countDays -= (end - start + 1);
            } else {
                /**
                 3. There is an overlap of meetings, so count only the uncovered days.
                 */
                if (end > previousEnd) {
                    countDays -= (end - previousEnd);
                }
            }

            // 4. Updated end time of last processed meeting.
            previousEnd = Math.max(end, previousEnd);
        }

        return countDays;
    }
}