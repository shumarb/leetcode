// Question: https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/description/

class NumberOfStudentsDoingHomeworkAtAGivenTime {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        boolean isTest = false;
        int count = 0;

        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                count++;
            }
        }
        if (isTest) {
            System.out.println("startTime: " + Arrays.toString(startTime));
            System.out.println("endTime: " + Arrays.toString(endTime));
            System.out.println("queryTime: " + queryTime + "\ncount: " + count);
        }

        return count;
    }
}