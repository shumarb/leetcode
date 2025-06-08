// Question: https://leetcode.com/problems/sum-of-all-odd-length-subarrays/description/

class SumOfAllOddLengthSubarrays {
    public int sumOddLengthSubarrays(int[] arr) {
        boolean isTest = false;
        int len = arr.length;
        int sum = 0;
        int windowSize = 3;

        // 1. 1-sized subarrays: compute sum of elements.
        if (isTest) {
            System.out.println("-------------------------------------------------");
            System.out.println("window size: 1");
        }
        for (int number: arr) {
            sum += number;
            if (isTest) {
                System.out.println(" * windowSum: " + number);
            }
        }
        if (isTest) {
            System.out.println(" ** sum: " + sum);
        }

        while (windowSize <= len) {
            if (isTest) {
                System.out.println("-------------------------------------------------");
                System.out.println("window size: " + windowSize);
            }

            int windowSum = 0;
            for (int i = 0; i < windowSize; i++) {
                windowSum += arr[i];
            }
            sum += windowSum;
            if (isTest) {
                System.out.println(" * windowSum: " + windowSum);
            }

            for (int i = windowSize; i < len; i++) {
                windowSum -= arr[i - windowSize];
                windowSum += arr[i];
                if (isTest) {
                    System.out.println(" * windowSum: " + windowSum);
                }
                sum += windowSum;
            }

            windowSize += 2;
        }

        if (isTest) {
            System.out.println("-------------------------------------------------");
            System.out.println("sum: " + sum);
        }

        return sum;
    }
}