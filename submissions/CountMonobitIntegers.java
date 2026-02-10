// Question: https://leetcode.com/problems/count-monobit-integers/description/

class CountMonobitIntegers {
    public int countMonobit(int n) {
        if (n <= 1) {
            return n + 1;
        }

        boolean isTest = false;
        int count = 1; // count 0.
        int current = 0;
        int power = 0;

        if (isTest) {
            System.out.println(" * valid: 0");
        }
        while (true) {
            current += (int) Math.pow(2, power);

            if (current > n) {
                break;
            }
            if (isTest) {
                System.out.println(" * valid: " + current);
            }

            count++;
            power++;
        }
        if (isTest) {
            System.out.println("-------------------------------");
            System.out.println("final current: " + current + "\ncount: " + count);
        }

        return count;
    }
}