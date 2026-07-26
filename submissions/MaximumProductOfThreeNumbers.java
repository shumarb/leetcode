// Question: https://leetcode.com/problems/maximum-product-of-three-numbers/description/

class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        boolean isTest = false;
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        int smallest = Integer.MAX_VALUE;
        int thirdLargest = Integer.MAX_VALUE;

        for (int e: nums) {
            if (e >= largest) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = e;
            } else if (e >= secondLargest) {
                thirdLargest = secondLargest;
                secondLargest = e;
            } else if (e >= thirdLargest) {
                thirdLargest = e;
            }

            if (e <= smallest) {
                secondSmallest = smallest;
                smallest = e;
            } else if (e <= secondSmallest) {
                secondSmallest = e;
            }
        }

        if (isTest) {
            System.out.println("largest: " + largest + "\nsecondLargest: " + secondLargest + "\nthirdLargest: " + thirdLargest + "\nsmallest: " + smallest + "\nsecondSmallest: " + secondSmallest);
        }

        return Math.max(largest * secondLargest * thirdLargest, smallest * secondSmallest * largest);
    }
}
