// Question: https://leetcode.com/problems/student-attendance-record-i/description/

class StudentAttendanceRecordOne {
    public boolean checkRecord(String s) {
        int countAbsent = 0;
        for (char letter: s.toCharArray()) {
            if (letter == 'A') {
                countAbsent++;
            }
        }
        return countAbsent < 2 && !isLateThreeConsecutive(s);
    }

    private boolean isLateThreeConsecutive(String s) {
        for (int i = 0; i <= s.length() - 3; i++) {
            if (s.charAt(i) == 'L' && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
                return true;
            }
        }
        return false;
    }
}