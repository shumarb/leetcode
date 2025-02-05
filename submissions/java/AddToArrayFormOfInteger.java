// Question: https://leetcode.com/problems/add-to-array-form-of-integer/description/

class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        boolean isTest = false;
        if (isTest) {
            System.out.println("num: " + Arrays.toString(num) + ", k: " + k);
        }

        int len = getBiggerLength(num.length, k);
        int i = num.length - 1;
        int carry = 0;
        int[] sumOfNumAndK = new int[len + 1];
        int j = len;

        while (i >= 0 || k > 0 || carry > 0) {
            int numDigit = (i >= 0) ? num[i] : 0;
            int kDigit = k % 10;
            int sum = numDigit + kDigit + carry;
            if (isTest) {
                System.out.println("numDigit: " + numDigit + ", kDigit: " + kDigit + "\nsum: " + sum);
            }
            sumOfNumAndK[j--] = sum % 10;
            carry = sum / 10;
            i--;
            k /= 10;
        }

        int startIndex = (sumOfNumAndK[0] == 0) ? 1 : 0;
        for (i = startIndex; i < len + 1; i++) {
            result.add(sumOfNumAndK[i]);
        }
        if (isTest) {
            System.out.println("sumOfNumAndK: " + Arrays.toString(sumOfNumAndK) + "\nresult: " + result);
        }

        return result;
    }

    private int getBiggerLength(int arrLength, int k) {
        int numOfDigitsOfK = 0;
        while (k != 0) {
            numOfDigitsOfK++;
            k /= 10;
        }
        return Math.max(arrLength, numOfDigitsOfK);
    }
}