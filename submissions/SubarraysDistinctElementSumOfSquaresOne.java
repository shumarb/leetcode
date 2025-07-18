// Question: https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/description/

class SubarraysDistinctElementSumOfSquaresOne {
    public int sumCounts(List<Integer> nums) {
        boolean isTest = false;
        int n = nums.size();
        int sumCounts = 0;

        if (isTest) {
            System.out.println("nums: " + nums);
        }
        for (int windowSize = 1; windowSize <= n; windowSize++) {
            if (isTest) {
                System.out.println("-----------------------------");
                System.out.println("window size: " + windowSize);
            }
            for (int i = 0; i <= n - windowSize; i++) {
                List<Integer> subList = nums.subList(i, i + windowSize);
                int countDistinct = countDistinct(subList);
                if (isTest) {
                    System.out.println(" * subList: " + subList + " -> countDistinct: " + countDistinct);
                }
                sumCounts += (countDistinct * countDistinct);
            }
        }
        if (isTest) {
            System.out.println("-----------------------------");
            System.out.println("sumCounts: " + sumCounts);
        }

        return sumCounts;
    }

    private int countDistinct(List<Integer> list) {
        boolean[] isPresent;
        int countDistinct = 0;
        int maximum = 0;

        for (int number: list) {
            maximum = Math.max(maximum, number);
        }
        isPresent = new boolean[maximum + 1];
        for (int number: list) {
            if (!isPresent[number]) {
                isPresent[number] = true;
                countDistinct++;
            }
        }

        return countDistinct;
    }
}