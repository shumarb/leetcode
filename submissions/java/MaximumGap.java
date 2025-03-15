// Question: https://leetcode.com/problems/maximum-gap/description/

class MaximumGap {
    public int maximumGap(int[] nums) {
        int maximumGap = 0;
        if (nums.length < 2) {
            return maximumGap;
        }

        // 1. Find maximum and minimum values.
        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;
        boolean isTest = false;
        for (int number: nums) {
            maximum = Math.max(number, maximum);
            minimum = Math.min(number, minimum);
        }

        // 2. Calculate bucket size & number of buckets.
        int bucketSize = Math.max(1, (maximum - minimum) / (nums.length - 1));
        int bucketCount = (maximum - minimum) / bucketSize + 1;

        // 3. Create buckets to keep track of maximum & minimum values per bucket.
        int[] bucketMinimum = new int[bucketCount];
        int[] bucketMaximum = new int[bucketCount];
        Arrays.fill(bucketMinimum, Integer.MAX_VALUE);
        Arrays.fill(bucketMaximum, Integer.MIN_VALUE);

        /**
         4.  Store each number into correct bucket,
         and determine maximum and minimum values in bucket
         after inserting the number into the bucket.
         */
        for (int number: nums) {
            int bucketIndex = (number - minimum) / bucketSize;
            bucketMinimum[bucketIndex] = Math.min(bucketMinimum[bucketIndex], number);
            bucketMaximum[bucketIndex] = Math.max(bucketMaximum[bucketIndex], number);
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("bucketMinimum: " + Arrays.toString(bucketMinimum));
            System.out.println("bucketMaximum: " + Arrays.toString(bucketMaximum));
        }

        // 5. Find maximum gap by comparing previous bucket's maximum and current bucket's minimum.
        maximumGap = 0;
        int previousMaximum = minimum;
        for (int i = 0; i < bucketCount; i++) {
            if (bucketMinimum[i] == Integer.MAX_VALUE) {
                continue;
            } else {
                maximumGap = Math.max(maximumGap, bucketMinimum[i] - previousMaximum);
                previousMaximum = bucketMaximum[i];
            }
        }

        return maximumGap;
    }
}