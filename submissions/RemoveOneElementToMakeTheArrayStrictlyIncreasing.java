// Question: https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/description/

class RemoveOneElementToMakeTheArrayStrictlyIncreasing {
    private boolean isSorted(int[] nums, int indexToIgnore) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i == indexToIgnore) {
                continue;
            }
            list.add(nums[i]);
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

    public boolean canBeIncreasing(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (isSorted(nums, i)) {
                return true;
            }
        }

        return false;
    }
}