// Question: https://leetcode.com/problems/maximize-expression-of-three-elements/description/

class MaximizeExpressionOfThreeElements {
    public int maximizeExpressionOfThree(int[] nums) {
        boolean isTest = false;
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int e: nums) {
            if (e >= largest) {
                secondLargest = largest;
                largest = e;
            } else if (e >= secondLargest) {
                secondLargest = e;
            }
            if (e < smallest) {
                smallest = e;
            }
        }
        if (isTest) {
            System.out.println("largest: " + largest + "\nsecondLargest: " + secondLargest + "\nsmallest: " + smallest);
        }

        return largest + secondLargest - smallest;
    }
}