// Question: https://leetcode.com/problems/permutation-sequence/description/

class PermutationSequence {
    private String result;
    private boolean isStop;
    private boolean isTest;
    private int[] digits;
    private int count;
    private int k;

    public String getPermutation(int n, int k) {
        count = 0;
        digits = new int[n];
        isStop = false;
        isTest = false;
        result = "";
        this.k = k;

        for (int i = 1; i <= n; i++) {
            digits[i - 1] = i;
        }
        for (int i = 0; i < n && !isStop; i++) {
            dfs(i, new StringBuilder(), new boolean[n]);
        }
        if (isTest) {
            System.out.println("----------------------------");
            System.out.println("n: " + n + ", k: " + k + "\ndigits: " + Arrays.toString(digits));
            System.out.println("----------------------------\nresult: " + result);
        }

        return result;
    }

    private void dfs(int i, StringBuilder path, boolean[] isVisited) {
        isVisited[i] = true;
        path.append(digits[i]);

        if (path.length() == isVisited.length) {
            if (isTest) {
                System.out.println(" * " + path);
            }
            if (++count == k) {
                result = path.toString();
                isStop = true;
            }
            return;
        }

        for (int j = 0; j < isVisited.length && !isStop; j++) {
            if (!isVisited[j]) {
                int originalLength = path.length();
                dfs(j, path, isVisited);
                isVisited[j] = false;
                path.setLength(originalLength);
                if (isStop) {
                    return;
                }
            }
        }
    }
}
