// Question: https://leetcode.com/problems/my-calendar-i/description/

class MyCalendar {
    private TreeMap<Integer, Integer> tree;
    private boolean isTest;

    public MyCalendar() {
        isTest = false;
        tree = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        if (isTest) {
            System.out.println("---------------------------------------------------------");
            System.out.println("book: (" + startTime + ", " + endTime + ")");
            System.out.println("\n ** before, tree: " + tree);
        }

        // 1. Retrieve the greatest start time smaller than endTime.
        Integer largestStartTime = tree.lowerKey(endTime);

        // 2. Overlap occurs when startTime starts before the booking whose startTime is largestStartTime ends.
        if (largestStartTime != null && startTime < tree.get(largestStartTime)) {
            if (isTest) {
                System.out.println("\n *** skipped");
            }
            return false;
        }
        tree.put(startTime, endTime);
        if (isTest) {
            System.out.println("\n ** after, tree: " + tree);
        }

        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */