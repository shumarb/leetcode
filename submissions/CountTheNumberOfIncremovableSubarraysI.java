// Question: https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-i/description/

class CountTheNumberOfIncremovableSubarraysI {
    public int incremovableSubarrayCount(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(j);
                if (isTest) {
                    System.out.print(" * indices to exclude: " + set);
                }

                List<Integer> list = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (set.contains(k)) {
                        continue;
                    }
                    list.add(nums[k]);
                }
                if (isTest) {
                    System.out.println(" | list: " + list);
                }

                boolean isIncreasing = true;
                for (int k = 1; k < list.size(); k++) {
                    if (list.get(k) <= list.get(k - 1)) {
                        isIncreasing = false;
                        break;
                    }
                }
                if (isIncreasing) {
                    result++;
                }
            }
        }
        return result;
    }
}
