// Question: https://leetcode.com/problems/my-calendar-i/description/

class MyCalendar {
    private List<int[]> bookings;
    private boolean isTest;

    public MyCalendar() {
        bookings = new ArrayList<>();
        isTest = false;
    }

    public boolean book(int startTime, int endTime) {
        if (isTest) {
            System.out.println(" * insert: " + startTime + ", " + endTime);
            display("\nbefore: ");
        }

        for (int[] booking: bookings) {
            if (Math.max(booking[0], startTime) < Math.min(booking[1], endTime)) {
                if (isTest) {
                    System.out.println(" * skipped\n-----------------------------------------------");
                }
                return false;
            }
        }
        bookings.add(new int[] {startTime, endTime});

        if (isTest) {
            display("\nafter: ");
            System.out.println("-----------------------------------------------");
        }

        return true;
    }

    private void display(String s) {
        System.out.println(s);
        for (int[] e: bookings) {
            System.out.println(Arrays.toString(e));
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */