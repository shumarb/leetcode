// Question: https://leetcode.com/problems/complete-prime-number/description/

class CompletePrimeNumber {
    public boolean completePrime(int num) {
        String value = Integer.toString(num);
        boolean isTest = false;
        int n = value.length();
        int prefix = 0;
        int suffix = 0;

        if (isTest) {
            System.out.println("value: " + value + "\n---------------------------------------\nprefix:");
        }
        for (int i = 0; i < n; i++) {
            prefix = Integer.parseInt(value.substring(0, i + 1));
            if (isTest) {
                System.out.print(" * prefix: " + prefix);
            }
            if (!isPrime(prefix)) {
                if (isTest) {
                    System.out.println(" -> not prime");
                }
                return false;
            }
            if (isTest) {
                System.out.println();
            }
        }

        if (isTest) {
            System.out.println("---------------------------------------\nsuffix:");
        }
        for (int i = n - 1; i >= 0; i--) {
            suffix = Integer.parseInt(value.substring(i));
            if (isTest) {
                System.out.print(" * suffix: " + suffix);
            }
            if (!isPrime(suffix)) {
                if (isTest) {
                    System.out.println(" -> not prime");
                }
                return false;
            }
            if (isTest) {
                System.out.println();
            }
        }

        return true;
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;

        } else if (n == 2) {
            return true;
        }

        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}