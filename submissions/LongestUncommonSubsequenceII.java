// Question: https://leetcode.com/problems/longest-uncommon-subsequence-i/description/

class LongestUncommonSubsequenceII {
    public int findLUSlength(String[] strs) {
        boolean isTest = false;
        int n = strs.length;
        int result = -1;

        if (isTest) {
            System.out.println("strs: " + Arrays.toString(strs));
        }
        for (int i = 0; i < n; i++) {
            String word1 = strs[i];
            boolean isUncommonSubsequence = true;

            if (isTest) {
                System.out.println("-----------------------------\ni: " + i + ", word1: " + word1 + "\n");
            }
            for (int j = 0; j < n; j++) {
                String word2 = strs[j];
                if (j == i) {
                    continue;
                }

                if (isTest) {
                    System.out.println(" * j: " + j + ", check in " + word2);
                }
                if (isSubsequence(word1.toCharArray(), word2.toCharArray())) {
                    isUncommonSubsequence = false;
                    break;
                }
            }

            if (isUncommonSubsequence) {
                if (isTest) {
                    System.out.println("\nvalid: " + word1);
                }

                result = Math.max(result, word1.length());
            }
        }

        return result;
    }

    private boolean isSubsequence(char[] first, char[] second) {
        int i = 0;
        int j = 0;
        int m = first.length;
        int n = second.length;

        while (i < m && j < n) {
            if (first[i] == second[j]) {
                i++;
            }

            j++;
        }

        return i == m;
    }
}
