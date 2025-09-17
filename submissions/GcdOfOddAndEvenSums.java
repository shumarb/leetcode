// Question: https://leetcode.com/problems/gcd-of-odd-and-even-sums/description/

class GcdOfOddAndEvenSums {
    public int gcdOfOddEvenSums(int n) {
        if (n == 1) {
            return 1;
        }

        boolean isTest = false;
        int evenIncrement = 2;
        int gcd = 1;
        int oddIncrement = 1;
        int sumEven = 0;
        int sumOdd = 0;

        for (int i = 0; i < n; i++) {
            if (isTest) {
                System.out.println("before:\n * sumEven: " + sumEven + "\n * sumOdd: " + sumOdd);
            }
            sumEven += evenIncrement;
            sumOdd += oddIncrement;
            evenIncrement += 2;
            oddIncrement += 2;
            if (isTest) {
                System.out.println("\nafter:\n * sumEven: " + sumEven + "\n * sumOdd: " + sumOdd);
                System.out.println("------------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("sumEven: " + sumEven + "\nsumOdd: " + sumOdd);
        }

        return gcd(Math.max(sumEven, sumOdd), Math.min(sumEven, sumOdd));
    }

    private int gcd(int first, int second) {
        return (first == 0) ? second : gcd(first % second, first);
    }
}