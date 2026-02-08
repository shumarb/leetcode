// Question: https://leetcode.com/problems/count-monobit-integers/description/

class CountMonobitIntegers {
    public int countMonobit(int n) {
        if (n <= 1) {
            return n + 1;
        }

        boolean isTest = false;
        int result = 2;

        for (int i = 3; i <= n; i++) {
            char[] bits = Integer.toBinaryString(i).toCharArray();
            if (isTest) {
                System.out.println(" * " + i + " -> bits: " + Arrays.toString(bits));
            }

            boolean isValid = true;
            for (int j = 1; j < bits.length; j++) {
                if (bits[j] != bits[j - 1]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                if (isTest) {
                    System.out.println(" ** valid: " + i);
                }
                result++;
            }
            if (isTest) {
                System.out.println("--------------------------");
            }
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}