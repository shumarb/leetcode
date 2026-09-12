// Question: https://leetcode.com/problems/unique-3-digit-even-numbers/description/

class Unique3DigitEvenNumbers {
    public int totalNumbers(int[] digits) {
        boolean[] isFormed = new boolean[999];
        boolean isTest = false;
        int n = digits.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (digits[i] == 0 || i == j) {
                    continue;
                }

                for (int k = 0; k < n; k++) {
                    if (digits[k] % 2 == 1 || k == i || k == j) {
                        continue;
                    }

                    int number = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (!isFormed[number]) {
                        if (isTest) {
                            System.out.println(" * " + number);
                        }
                        isFormed[number] = true;
                        result++;
                    }
                }
            }
        }

        return result;
    }
}
