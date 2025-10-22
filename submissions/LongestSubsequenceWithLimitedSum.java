// Question: https://leetcode.com/problems/longest-subsequence-with-limited-sum/description/

class LongestSubsequenceWithLimitedSum {
    public int[] answerQueries(int[] nums, int[] queries) {
        boolean isTest = false;
        int n = queries.length;
        int[] answer = new int[n];

        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int count = 0;
            int j = 0;
            int limit = queries[i];
            int sum = 0;

            if (isTest) {
                System.out.println("i: " + i + ", limit: " + limit);
            }
            while (j < nums.length && (sum + nums[j]) <= limit) {
                if (isTest) {
                    System.out.println("\n * before, sum: " + sum + ", count: " + count + "\n ** counting: " + nums[j]);
                }
                sum += nums[j];
                count++;
                j++;
                if (isTest) {
                    System.out.println(" * after, sum: " + sum + ", count: " + count);
                }
            }
            if (isTest) {
                System.out.println("\n ** answer[" + i + "]: " + count);
                System.out.println("-----------------------------------------------");
            }

            answer[i] = count;
        }

        return answer;
    }
}