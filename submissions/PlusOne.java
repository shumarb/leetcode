// Question: https://leetcode.com/problems/plus-one/description/

class PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] result = new int[len];
        boolean isTest = false;
        if (isTest) {
            System.out.println("digits: " + Arrays.toString(digits));
        }

        for (int i = len - 1; i >= 0; i--) {
            // 1. Current digit is < 9, so increase it for final answer
            if (digits[i] < 9) {
                digits[i]++;
                if (isTest) {
                    System.out.println("returning: " + Arrays.toString(digits));
                }
                return digits;

                // 2. Since current digit == 9, there is a carry over of 1 to the next most-significant digit
                // and current digit becomes 0
            } else {
                digits[i] = 0;
            }
            if (isTest) {
                System.out.println("digits so far: " + Arrays.toString(digits));
            }
        }

        if (isTest) {
            System.out.println("digits so far: " + Arrays.toString(digits));
        }

        // 3. All digits in initial array are 9, so there is a carry-over of 1 for every digit
        // hence, all digits are currently 0
        // so create a new array is to be created where the most-significant bit is 1 and all others are 0.
        int[] newNumber = new int[len + 1];
        newNumber[0] = 1;
        if (isTest) {
            System.out.println("returning: " + Arrays.toString(newNumber));
        }

        return newNumber;
    }
}