// Question: https://leetcode.com/problems/number-of-employees-who-met-the-target/description/

class NumberOfEmployeesWhoMetTheTarget {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;
        for (int employeeHours: hours) {
            if (employeeHours >= target) {
                count++;
            }
        }
        return count;
    }
}