// Question: https://leetcode.com/problems/check-if-any-element-has-prime-frequency/description/

class CheckIfAnyElementHasPrimeFrequency {
    public boolean checkPrimeFrequency(int[] nums) {
        boolean isTest = false;
        int largest = 0;
        int[] frequency;

        for (int number: nums) {
            largest = Math.max(largest, number);
        }
        frequency = new int[largest + 1];
        for (int number: nums) {
            frequency[number]++;
        }
        if (isTest) {
            System.out.println("nums:      " + Arrays.toString(nums));
            System.out.println("frequency: " + Arrays.toString(frequency));
        }

        for (int freq: frequency) {
            if (freq <= 1) {
                continue;
            }
            if (isPrime(freq)) {
                return true;
            }
        }

        return false;
    }

    private boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}