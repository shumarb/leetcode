// Question: https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/description/

class AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public double average(int[] salary) {
        double maximum = Double.MIN_VALUE;
        double minimum = Double.MAX_VALUE;
        double sum = 0;

        for (int value: salary) {
            sum += value;
            maximum = Math.max(maximum, (double) value);
            minimum = Math.min(minimum, (double) value);
        }

        return (sum - maximum - minimum) / (salary.length - 2);
    }
}