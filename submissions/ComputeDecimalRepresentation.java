// Question: https://leetcode.com/problems/compute-decimal-representation/description/

class ComputeDecimalRepresentation {
    public int[] decimalRepresentation(int n) {
        boolean isTest = false;
        int[] result;
        int count = 0;
        int i;
        int nCopy = n;
        int power = 0;

        while (nCopy > 0) {
            if (nCopy % 10 > 0) {
                count++;
            }
            nCopy /= 10;
        }

        result = new int[count];
        i = count - 1;
        while (n > 0) {
            int digit = n % 10;
            int number = (int) Math.pow(10, power++) * digit;
            if (i >= 0 && number != 0) {
                result[i--] = number;
            }
            n /= 10;
        }
        if (isTest) {
            System.out.println("count: " + count + "\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}