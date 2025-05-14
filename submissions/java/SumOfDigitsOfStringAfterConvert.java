// Question: https://leetcode.com/problems/sum-of-digits-of-string-after-convert/description/

class SumOfDigitsOfStringAfterConvert {
    public int getLucky(String s, int k) {
        boolean isTest = false;
        int sum = 0;

        if (isTest) {
            System.out.println("s: " + s + "\nk: " + k + "\n\nConversion:");
        }
        for (char c: s.toCharArray()) {
            int value = c - 'a' + 1;
            if (value >= 10) {
                if (isTest) {
                    System.out.println(" * adding: " + (value % 10) + ", " + (value / 10));
                }
                sum += (value % 10 + value / 10);
            } else {
                if (isTest) {
                    System.out.println(" * adding: " + value);
                }
                sum += value;
            }
        }
        if (isTest) {
            System.out.println("\nsum: " + sum);
            System.out.println("---------------------------------------------------------------------------------");
        }

        for (int i = 0; i < k - 1; i++) {
            sum = digitSum(sum);
        }

        return sum;
    }

    private int digitSum(int number) {
        int digitSum = 0;
        while (number != 0) {
            digitSum += number % 10;
            number /= 10;
        }
        return digitSum;
    }
}