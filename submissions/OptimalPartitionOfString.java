// Question: https://leetcode.com/problems/optimal-partition-of-string/description/

class OptimalPartitionOfString {
    public int partitionString(String s) {
        // 1. Edge case: s has only 1 character.
        if (s.length() == 1) {
            return 1;
        }

        StringBuilder partition = new StringBuilder();
        boolean[] isUsed = new boolean[26];
        boolean isTest = false;
        int result = 0;

        for (char c: s.toCharArray()) {
            if (!isUsed[c - 'a']) {
                partition.append(c);

            } else {
                if (isTest) {
                    System.out.println(" * partition: " + partition);
                }
                result++;
                partition = new StringBuilder();
                partition.append(c);
                Arrays.fill(isUsed, false);
            }

            isUsed[c - 'a'] = true;
        }
        if (partition.length() > 0) {
            result++;
            if (isTest) {
                System.out.println(" * partition: " + partition);
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------\nresult: " + result);
        }

        return result;
    }
}