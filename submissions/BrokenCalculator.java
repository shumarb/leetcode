// Question: https://leetcode.com/problems/broken-calculator/description/

class BrokenCalculator {
    public int brokenCalc(int startValue, int target) {
        boolean isTest = false;
        int minimumOperations = 0;

        if (isTest) {
            System.out.println("startValue: " + startValue);
            System.out.println("---------------------------------------------------------");
        }
        while (target > startValue) {
            if (isTest) {
                System.out.println("before | target: " + target);
            }

            if (target % 2 == 1) {
                target++;
            } else {
                target /= 2;
            }

            if (isTest) {
                System.out.println("after  | target: " + target);
                System.out.println("---------------------------------------------------------");
            }

            minimumOperations++;
        }
        if (isTest) {
            System.out.println("final | target: " + target + ", startValue: " + startValue + "\nminimumOperations: " + minimumOperations);
        }

        return minimumOperations + (startValue - target);
    }
}