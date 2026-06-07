// Question: https://leetcode.com/problems/valid-binary-strings-with-cost-limit/description/

class ValidBinaryStringsWithCostLimit {
    private List<String> result;
    private boolean isTest;
    private int k;
    private int n;

    public List<String> generateValidStrings(int n, int k) {
        isTest = false;
        result = new ArrayList<>();
        this.k = k;
        this.n = n;

        dfs(new StringBuilder());
        if (isTest) {
            System.out.println("---------------------------\nresult:");
            for (String e: result) {
                System.out.println(" * " + e);
            }
        }

        return result;
    }

    private void dfs(StringBuilder current) {
        if (isTest) {
            System.out.println("current: " + current);
        }

        if (current.length() == n) {
            if (isValid(current.toString())) {
                result.add(current.toString());
            }
            return;
        }

        int len = current.length();

        current.append("0");
        dfs(current);
        current.setLength(len);

        current.append("1");
        dfs(current);
        current.setLength(len);
    }

    private boolean isValid(String s) {
        char[] bits = s.toCharArray();
        int cost = 0;
        int n = bits.length;

        for (int i = 1; i < n; i++) {
            if (bits[i] == '1' && bits[i - 1] == '1') {
                return false;
            }
            if (bits[i] == '1') {
                cost += i;
            }
        }

        return cost <= k;
    }
}
