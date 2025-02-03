// Question: https://leetcode.com/problems/separate-the-digits-in-an-array/description/

class SeparateTheDigitsInAnArray {
    public int[] separateDigits(int[] nums) {
        boolean t = false;
        List<Character> digits = new ArrayList<> ();

        for (int x: nums) {
            char[] xDigits = String.valueOf(x).toCharArray();
            for (char digit: xDigits) {
                digits.add(digit);
            }
        }
        if (t) {
            System.out.println("nums: " + Arrays.toString(nums) + " | digits: " + digits);
        }

        int[] result = new int[digits.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = Character.getNumericValue(digits.get(i));
        }
        if (t) {
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}