// Question: https://leetcode.com/problems/self-dividing-numbers/description/

class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isSelfDividingNumber(int number) {
        boolean isTest = false;
        int numberCopy = number;
        if (isTest) {
            System.out.println("checking is self-dividing: " + number);
        }

        while (numberCopy != 0) {
            int digit = numberCopy % 10;
            if (isTest) {
                System.out.println("digit: " + digit);
            }
            if (digit == 0 || number % digit != 0) {
                return false;
            }
            if (isTest) {
                System.out.println(number + " is divisible by " + digit);
            }
            numberCopy /= 10;
        }

        return true;
    }
}