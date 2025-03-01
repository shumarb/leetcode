// Question:

class CountSymmetricIntegers {
    public int countSymmetricIntegers(int low, int high) {
        // 1. Integers up to 10 are non symmetric.
        if (high <= 10) {
            return 0;
        }

        int countSymmetricIntegers = 0;
        for (int i = low; i <= high; i++) {
            String numberStr = Integer.toString(i);
            if (numberStr.length() % 2 == 0 && isSymmetric(numberStr)) {
                countSymmetricIntegers++;
            }
        }

        return countSymmetricIntegers;
    }

    private boolean isSymmetric(String numberStr) {
        int sum = 0;
        int length = numberStr.length();
        int n = length / 2;

        for (int i = 0; i < n; i++) {
            sum += Character.getNumericValue(numberStr.charAt(i));
        }
        for (int i = n; i < length; i++) {
            sum -= Character.getNumericValue(numberStr.charAt(i));
        }

        return sum == 0;
    }
}