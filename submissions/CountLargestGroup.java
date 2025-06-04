// Question: https://leetcode.com/problems/count-largest-group/description/

class CountLargestGroup {
    public int countLargestGroup(int n) {
        /**
         1.  Every index represent a sum,
             and each element represent total number of times
             the sum of digits of each from 1 to n.

             Eg: sumFrequency[2] = 3 means there are 3 elements
             from 1 to n where its sum of digits is 2.

             sumFrequency stores 37 elements (1-based counting)
             because maximum sum of digits is 36 (derived from 9999: 9 + 9 + 9 + 9),
             hence set its size to 37 to that 36 can be accessed (last element).
         */
        int[] sumFrequency = new int[37];
        boolean isTest = false;

        for (int i = 1; i <= n; i++) {
            int sumOfDigits = computeSumOfDigits(i);
            sumFrequency[sumOfDigits]++;
        }
        if (isTest) {
            System.out.println("sumFrequency: " + Arrays.toString(sumFrequency));
        }

        /**
            2.  Largest group is the largest element in sumFrequency.
         */
        int largest = sumFrequency[0];
        for (int value: sumFrequency) {
            largest = Math.max(largest, value);
        }

        /**
            3.  If an element is equal to largest,
                it is part of the largest group.
         */
        int largestGroup = 0;
        for (int number: sumFrequency) {
            if (number == largest) {
                largestGroup++;
            }
        }
        return largestGroup;
    }

    private int computeSumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}