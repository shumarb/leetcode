// Question: https://leetcode.com/problems/sum-of-largest-prime-substrings/description/

class SumOfLargestPrimeSubstrings {
    public long sumOfLargestPrimes(String s) {
        Set<Long> set = new HashSet<>();
        boolean isTest = false;
        int n = s.length();
        long largest = 0l;
        long result = 0l;
        long secondLargest = 0l;
        long thirdLargest = 0l;

        for (int i = 0; i < n; i++) {
            long value = 0;
            for (int j = i; j < n; j++) {
                value = value * 10 + s.charAt(j) - '0';
                if (value > 1 && !set.contains(value) && isPrime(value)) {
                    if (isTest) {
                        System.out.println(" * unique prime: " + value);
                    }
                    set.add(value);

                    if (value > largest) {
                        thirdLargest = secondLargest;
                        secondLargest = largest;
                        largest = value;

                    } else if (value > secondLargest) {
                        thirdLargest = secondLargest;
                        secondLargest = value;

                    } else if (value > thirdLargest) {
                        thirdLargest = value;
                    }
                }
            }
        }

        if (largest > 1l) {
            result += largest;
        }
        if (secondLargest > 1l) {
            result += secondLargest;
        }
        if (thirdLargest > 1l) {
            result += thirdLargest;
        }
        if (isTest) {
            System.out.println("----------------------------------\nlargest: " + largest);
            System.out.println("secondLargest: " + secondLargest + "\nthirdLargest: " + thirdLargest);
        }

        return result;
    }

    private boolean isPrime(long value) {
        for (long i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }

        return true;
    }
}