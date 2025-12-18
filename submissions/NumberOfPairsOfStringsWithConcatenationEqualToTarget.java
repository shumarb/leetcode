// Question: https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/description/

class NumberOfPairsOfStringsWithConcatenationEqualToTarget {
    public int numOfPairs(String[] nums, String target) {
        boolean isTest = false;
        int n = nums.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            StringBuilder current = new StringBuilder();
            current.append(nums[i]);
            int len = current.length();
            if (isTest) {
                System.out.println("---------------------------\ni: " + i + "\ncurrent: " + current);
            }
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }
                String incoming = nums[j];
                if (isTest) {
                    System.out.print(" * j: " + j + " | incoming: " + incoming + " | before, current: " + current);
                }
                current.append(nums[j]);
                if (isTest) {
                    System.out.println(" | after, current: " + current);
                }
                if (current.toString().equals(target)) {
                    result++;
                }
                current.setLength(len);
            }
        }

        return result;
    }
}