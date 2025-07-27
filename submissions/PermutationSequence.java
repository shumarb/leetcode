// Question: https://leetcode.com/problems/permutation-sequence/description/

class PermutationSequence {
    private List<String> paths;
    private boolean isStop = false;
    private int[] digits;
    private int k;

    public String getPermutation(int n, int k) {
        boolean isTest = false;
        digits = new int[n];
        paths = new ArrayList<>();
        this.k = k;

        for (int i = 1; i <= n; i++) {
            digits[i - 1] = i;
        }
        for (int i = 0; i < n && !isStop; i++) {
            dfs(i, new StringBuilder(), new boolean[n]);
        }
        if (isTest) {
            System.out.println("n: " + n + ", k: " + k + "\ndigits: " + Arrays.toString(digits));
            System.out.println("----------------------------\npaths:");
            for (String path: paths) {
                System.out.println(" * " + path);
            }
            System.out.println("----------------------------\nresult: " + paths.get(k - 1));
        }

        return paths.get(k - 1);
    }

    private void dfs(int i, StringBuilder path, boolean[] isVisited) {
        isVisited[i] = true;
        path.append(digits[i]);

        if (path.length() == isVisited.length) {
            paths.add(path.toString());
            if (paths.size() == k) {
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
            }
        }
    }
}