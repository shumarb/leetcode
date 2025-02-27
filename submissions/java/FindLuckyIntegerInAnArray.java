// Question: https://leetcode.com/problems/find-lucky-integer-in-an-array/description/

class FindLuckyIntegerInAnArray {
    public int findLucky(int[] arr) {
        int maximum = arr[0];
        for (int number: arr) {
            maximum = Math.max(number, maximum);
        }

        int[] numberFrequency = new int[maximum + 1];
        for (int number: arr) {
            numberFrequency[number]++;
        }

        int luckyInteger = -1;
        for (int i = 1; i <= maximum; i++) {
            if (numberFrequency[i] == i) {
                luckyInteger = i;
            }
        }

        return luckyInteger;
    }
}