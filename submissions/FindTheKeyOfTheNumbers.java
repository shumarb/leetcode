// Question: https://leetcode.com/problems/find-the-key-of-the-numbers/description/

class FindTheKeyOfTheNumbers {
    public int generateKey(int num1, int num2, int num3) {
        boolean isTest = false;
        int key = 0;
        int[] digits = new int[4];

        if (isTest) {
            System.out.println("num1: " + num1 + "\nnum2: " + num2 + "\nnum3: " + num3);
        }
        for (int i = 3; i >= 0; i--) {
            digits[i] = Math.min(num1 % 10, Math.min(num2 % 10, num3 % 10));
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
        }
        for (int digit: digits) {
            key = key * 10 + digit;
        }
        if (isTest) {
            System.out.println("digits: " + Arrays.toString(digits) + "\nkey: " + key);
        }

        return key;
    }
}