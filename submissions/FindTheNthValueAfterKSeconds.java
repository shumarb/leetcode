// Question: https://leetcode.com/problems/find-the-n-th-value-after-k-seconds/description/

class FindTheNthValueAfterKSeconds {
    public int valueAfterKSeconds(int n, int k) {
        boolean isTest = false;
        int[] prefix = new int[n];
        int current = 0;

        Arrays.fill(prefix, 1);
        while (current < k) {
            if (isTest) {
                System.out.println(" * current: " + current + " -> prefix: " + Arrays.toString(prefix));
            }
            for (int i = 1; i < n; i++) {
                prefix[i] = (prefix[i] + prefix[i - 1]) % 1000000007;
            }
            current++;
        }
        if (isTest) {
            System.out.println("------------------------------------------------");
            System.out.println("prefix: " + Arrays.toString(prefix));
            System.out.println("result: " + prefix[n - 1]);
        }

        return prefix[n - 1];
    }
}