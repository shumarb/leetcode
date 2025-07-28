// Question: https://leetcode.com/problems/sum-of-all-subset-xor-totals/description/

class SumOfAllSubsetXorTotals {
    private boolean isTest;
    private int subsetXORSum;

    public int subsetXORSum(int[] nums) {
        isTest = false;
        subsetXORSum = 0;

        dfs(0, new ArrayList<>(), nums);

        return subsetXORSum;
    }

    private void dfs(int startIndex, List<Integer> path, int[] nums) {
        int XORSum = 0;

        for (int number: path) {
            XORSum ^= number;
        }
        subsetXORSum += XORSum;
        if (isTest) {
            System.out.println("-----------------------------\npath: " + path);
            System.out.println("XORSum: " + XORSum + " | subsetXORSum: " + subsetXORSum);
        }

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(i + 1, path, nums);
            path.removeLast();
        }
    }
}