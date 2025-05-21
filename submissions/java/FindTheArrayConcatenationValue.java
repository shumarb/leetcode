// Question: https://leetcode.com/problems/find-the-array-concatenation-value/description/

class Solution {
    public long findTheArrayConcVal(int[] nums) {
        boolean isTest = false;
        int left = 0;
        int right = nums.length - 1;
        long concatenationValue = 0;

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("-------------------------------------------------------------");
        }

        while (left < right) {
            int toAdd = nums[left];
            int countDigits = 0;
            int copy = nums[right];

            // 1. Count number of times to shift all digits of element at left index to the left.
            while (copy != 0) {
                countDigits++;
                copy /= 10;
            }
            while (countDigits != 0) {
                toAdd *= 10;
                countDigits--;
            }
            toAdd += nums[right];
            if (isTest) {
                System.out.println(" * before | concatenationValue: " + concatenationValue);
                System.out.println(" * left: " + left + " --> element: " + nums[left]);
                System.out.println(" * right: " + right + " --> element: " + nums[right]);
                System.out.println(" * toAdd: " + toAdd);
            }
            concatenationValue += toAdd;
            if (isTest) {
                System.out.println(" * after | concatenationValue: " + concatenationValue);
                System.out.println("-------------------------------------------------------------");
            }
            left++;
            right--;
        }

        /**
         2.  Edge case: Add middle element if nums has odd number of elements.
            At this point, middle index is left.
         */
        if (nums.length % 2 == 1) {
            concatenationValue += nums[left];
        }
        if (isTest) {
            System.out.println("concatenationValue: " + concatenationValue + "\nleft: " + left);
        }

        return concatenationValue;
    }
}