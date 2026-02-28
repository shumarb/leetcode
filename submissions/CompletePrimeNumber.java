// Question: https://leetcode.com/problems/complete-prime-number/description/

class CompletePrimeNumber {
    private boolean isTest;

    public boolean completePrime(int num) {
        isTest = false;
        int[] digits = getDigits(num);
        int number = 0;

        if (isTest) {
            System.out.println("num: " + num + "\ndigits: " + Arrays.toString(digits) + "\n------------------------\nprefix:");
        }
        for (int i = 0; i < digits.length; i++) {
            number *= 10;
            number += digits[i];
            if (isTest) {
                System.out.print(" * number: " + number);
            }
            if (!isPrime(number)) {
                if (isTest) {
                    System.out.println(" ==> not prime");
                }
                return false;
            }
            if (isTest) {
                System.out.println();
            }
        }

        if (isTest) {
            System.out.println("------------------------\nsuffix:");
        }

        StringBuilder sb = new StringBuilder();
        for (int d: digits) {
            sb.append(d);
        }
        String value = sb.toString();
        int len = value.length();
        for (int i = len - 1; i >= 0; i--) {
            number = Integer.parseInt(value.substring(i, len));
            if (isTest) {
                System.out.print(" * number: " + number);
            }
            if (!isPrime(number)) {
                if (isTest) {
                    System.out.println(" ==> not prime");
                }
                return false;
            }
            if (isTest) {
                System.out.println();
            }
        }

        return true;
    }

    private int reverse(int n) {
        if (isTest) {
            System.out.println(" ** to reverse: " + n);
        }
        int number = 0;

        while (n > 0) {
            number *= 10;
            number += (n % 10);
            n /= 10;
        }

        return number;
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    private int[] getDigits(int n) {
        int[] digits;
        int i;
        int nCopy = n;
        int size = 0;

        while (nCopy > 0) {
            size++;
            nCopy /= 10;
        }

        digits = new int[size];
        i = size - 1;
        nCopy = n;
        while (i >= 0 && nCopy > 0) {
            digits[i--] = nCopy % 10;
            nCopy /= 10;
        }

        return digits;
    }
}