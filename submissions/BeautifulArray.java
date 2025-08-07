// Question: https://leetcode.com/problems/beautiful-array/description/

class BeautifulArray {
    public int[] beautifulArray(int n) {
        if (n == 1) {
            return new int[] {1};
        }

        boolean isTest = false;
        int[] even = beautifulArray(n / 2);
        int[] odd = beautifulArray((n + 1) / 2);
        int[] result = new int[n];
        int i = 0;

        for (int number: even) {
            result[i++] = 2 * number;
        }
        for (int number: odd) {
            result[i++] = 2 * number - 1;
        }

        return result;
    }
}