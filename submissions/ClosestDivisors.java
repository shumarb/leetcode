// Question: https://leetcode.com/problems/closest-divisors/description/

class ClosestDivisors {
    public int[] closestDivisors(int num) {
        boolean isTest = false;
        int[] first = getPair(num + 1);
        int[] second = getPair(num + 2);

        if (isTest) {
            System.out.println((num + 1) + ": " + Arrays.toString(first) + "\n" + (num + 2) + ": " + Arrays.toString(second));
        }

        return first[1] - first[0] <= second[1] - second[0] ? first : second;
    }

    private int[] getPair(int key) {
        int[] result = new int[2];

        for (int i = 1; i <= Math.sqrt(key); i++) {
            if (key % i == 0) {
                result[0] = i;
                result[1] = key / i;
            }
        }

        return result;
    }
}