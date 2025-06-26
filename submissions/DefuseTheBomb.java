// Question: https://leetcode.com/problems/defuse-the-bomb/description/

class Solution {
    public int[] decrypt(int[] code, int k) {
        boolean isTest = false;
        int n = code.length;
        int[] result = new int[n];

        if (k == 0) {
            return result;
        }

        if (isTest) {
            System.out.println("k: " + k + "\ncode: " + Arrays.toString(code));
        }
        for (int i = 0; i < n; i++) {
            if (isTest) {
                System.out.println("-----------------------------------------------------------------");
                System.out.println("i: " + i);
            }
            int sum = 0;
            for (int j = 1; j <= Math.abs(k); j++) {
                int index = (k > 0) ? (i + j) % n : (i - j + n) % n;
                if (isTest) {
                    System.out.println(" * add | index: " + index + ", element: " + code[index]);
                }
                sum += code[index];
            }
            result[i] = sum;
        }
        if (isTest) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}