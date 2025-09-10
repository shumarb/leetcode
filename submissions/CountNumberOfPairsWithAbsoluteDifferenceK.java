// Question: https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/description/

class CountNumberOfPairsWithAbsoluteDifferenceK {
    public int countKDifference(int[] nums, int k) {
        boolean isTest = false;
        int[] map = formsMap(nums);
        int count = 0;

        if (isTest) {
            System.out.println("map: " + Arrays.toString(map));
        }
        for (int number: nums) {
            int complement = number + k;
            if (complement >= 0 && complement < map.length && map[complement] > 0) {
                count += map[complement];
            }
        }

        return count;
    }

    private int[] formsMap(int[] nums) {
        int[] map;
        int largest = nums[0];

        for (int i = 1; i < nums.length; i++) {
            largest = Math.max(largest, nums[i]);
        }

        map = new int[largest + 1];
        for (int number: nums) {
            map[number]++;
        }

        return map;
    }
}