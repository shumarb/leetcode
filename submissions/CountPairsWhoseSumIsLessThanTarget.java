// Question: https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/description/

class CountPairsWhoseSumIsLessThanTarget {
    public int countPairs(List<Integer> nums, int target) {
        int countPairs = 0;
        int[] arr = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            arr[i] = nums.get(i);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] < target) {
                    countPairs++;
                }
            }
        }

        return countPairs;
    }
}