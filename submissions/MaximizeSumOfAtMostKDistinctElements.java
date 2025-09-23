// Question: https://leetcode.com/problems/maximize-sum-of-at-most-k-distinct-elements/description/

class MaximizeSumOfAtMostKDistinctElements {
    public int[] maxKDistinct(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        boolean isTest = false;
        int[] result = null;
        int j = 0;
        int total = 0;

        Arrays.sort(nums);
        for (int i = nums.length - 1; set.size() < k && i >= 0; i--) {
            int element = nums[i];
            if (set.contains(element)) {
                continue;
            }

            set.add(element);
            total++;
        }

        result = new int[set.size()];
        set.clear();
        for (int i = nums.length - 1; set.size() < k && i >= 0; i--) {
            int element = nums[i];
            if (!set.contains(element)) {
                set.add(element);
                result[j++] = element;
            }
        }
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums));
            System.out.println("set: " + set + "\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}