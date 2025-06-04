// Question: https://leetcode.com/problems/max-pair-sum-in-an-array/description/

class MaxPairSumInAnArray {
    public int maxSum(int[] nums) {
        Pair[] largestPairPerDigit = new Pair[10];
        boolean isTest = false;
        int maxSumPair = -1;

        for (int i = 0; i < 10; i++) {
            largestPairPerDigit[i] = new Pair(-1, -1);
        }

        for (int number: nums) {
            int largestDigit = findLargestDigit(number);
            Pair largestDigitPair = largestPairPerDigit[largestDigit];
            if (number > largestDigitPair.getLargest()) {
                largestDigitPair.setSecondLargest(largestDigitPair.getLargest());
                largestDigitPair.setLargest(number);
            } else if (number > largestDigitPair.getSecondLargest()) {
                largestDigitPair.setSecondLargest(number);
            }
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("largestPairPerDigit:");
            for (int i = 0; i < 10; i++) {
                Pair pair = largestPairPerDigit[i];
                System.out.println(" * index: " + i + " --> [" + pair.getLargest() + ", " + pair.getSecondLargest() + "]");
            }
        }

        for (Pair pair: largestPairPerDigit) {
            int largest = pair.getLargest();
            int secondLargest = pair.getSecondLargest();
            if (largest != -1 && secondLargest != -1) {
                maxSumPair = Math.max(maxSumPair, largest + secondLargest);
            }
        }
        if (isTest) {
            System.out.println("max sum pair: " + maxSumPair);
        }

        return maxSumPair;
    }

    private int findLargestDigit(int number) {
        int largestDigit = 0;
        while (number != 0) {
            largestDigit = Math.max(largestDigit, number % 10);
            number /= 10;
        }
        return largestDigit;
    }
}

class Pair {
    int largest;
    int secondLargest;

    public Pair(int largest, int secondLargest) {
        this.largest = largest;
        this.secondLargest = secondLargest;
    }

    public int getLargest() {
        return largest;
    }

    public int getSecondLargest() {
        return secondLargest;
    }

    public void setLargest(int largest) {
        this.largest = largest;
    }

    public void setSecondLargest(int secondLargest) {
        this.secondLargest = secondLargest;
    }
}