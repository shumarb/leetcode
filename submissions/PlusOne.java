// Question: https://leetcode.com/problems/plus-one/description/

class PlusOne {
    public int[] plusOne(int[] digits) {
        public int[] plusOne(int[] digits) {
            boolean isTest = false;
            int carry = 1;
            int len = digits.length;

            for (int i = len - 1; i >= 0; i--) {
                int sum = carry + digits[i];
                digits[i] = sum % 10;
                carry = sum / 10;

            }
            if (isTest) {
                System.out.println("digits: " + Arrays.toString(digits) + "\ncarry: " + carry);
            }

            if (carry == 0) {
                return digits;
            }

            int[] result = new int[len + 1];
            result[0] = carry;
            for (int i = 1; i < result.length; i++) {
                result[i] = digits[i - 1];
            }
            if (isTest) {
                System.out.println("result: " + Arrays.toString(result));
            }

            return result;
        }
    }