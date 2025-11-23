// Question: https://leetcode.com/problems/word-break/description/

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int longest = 0;
        int n = s.length();
        boolean isTest = false;
        boolean[] memo = new boolean[n + 1];

        for (String w: wordDict) {
            longest = Math.max(longest, w.length());
        }
        memo[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= Math.max(0, i - longest); j--) {
                String current = s.substring(j, i);
                if (isTest) {
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("s: " + s + "\n * memo: " + Arrays.toString(memo));
                    System.out.println(" * j: " + i + ", i: " + i + "\n ** current: " + current);
                }
                if (memo[j] && set.contains(current)) {
                    memo[i] = true;
                    if (isTest) {
                        System.out.println("\n *** found: " + current);
                        System.out.println(" *** memo: " + Arrays.toString(memo));
                    }
                    break;
                }
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("memo: " + Arrays.toString(memo));
        }
        return memo[n];
    }
}