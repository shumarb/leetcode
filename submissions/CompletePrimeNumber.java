// Question: https://leetcode.com/problems/complete-prime-number/description/

class CompletePrimeNumber {
    public boolean completePrime(int num) {
        String number = Integer.toString(num);
        boolean isTest = false;

        for (int i = 0; i < number.length(); i++) {
            int prefix = Integer.parseInt(number.substring(0, i + 1));
            int suffix = Integer.parseInt(number.substring(i));
            if (isTest) {
                System.out.println("i: " + i);
                System.out.println(" * prefix: " + prefix + "\n * suffix: " + suffix);
                System.out.println("-----------------------------------------------");
            }

            if (!isPrime(prefix) || !isPrime(suffix)) {
                return false;
            }
        }

        return true;
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;

        } else if (num == 2) {
            return true;
        }

        int limit = (int) Math.sqrt(num);
        for (int i = 2; i <= limit; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}