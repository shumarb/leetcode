// Question: https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/description/

class SubarraysDistinctElementSumOfSquaresOne {
    public int sumCounts(List<Integer> nums) {
        int maximum = 0;
        int n = nums.size();
        int sumCounts = 0;

        for (int number: nums) {
            maximum = Math.max(maximum, number);
        }
        for (int i = 0; i < n; i++) {
            /**
             1.  Use boolean array to keep track of distinct arrays
                 in all subarrays starting from index i to n.
             */
            boolean[] isPresent = new boolean[maximum + 1];
            int countDistinct = 0;
            for (int j = i; j < n; j++) {
                int element = nums.get(j);
                if (!isPresent[element]) {
                    isPresent[element] = true;
                    countDistinct++;
                }
                sumCounts += (countDistinct * countDistinct);
            }
        }

        return sumCounts;
    }
}