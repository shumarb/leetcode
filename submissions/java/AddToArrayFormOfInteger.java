// Question: https://leetcode.com/problems/add-to-array-form-of-integer/description/

class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] num, int k) {
        boolean isTest = false;
        if (isTest) {
            System.out.println("num: " + Arrays.toString(num) + " | k: " + k);
        }

        int carryOver = 0;
        int i = num.length - 1;
        List<Integer> result = new ArrayList<>();
        while (i >= 0 || k > 0 || carryOver > 0) {
            int numDigit = (i >= 0) ? num[i] : 0;
            int kDigit = k % 10;

            int sum = numDigit + kDigit + carryOver;
            carryOver = sum / 10;
            result.add(0, sum % 10);

            i--;
            k /= 10;
        }

        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}