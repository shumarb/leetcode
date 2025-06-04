// Question: https://leetcode.com/problems/find-the-difference-of-two-arrays/description/

class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] set1 = getSet(nums1);
        boolean[] set2 = getSet(nums2);

        for (int i = 0; i < 2; i++) {
            List<Integer> list = new ArrayList<>();
            if (i == 0) {
                list = getNumbersNotPresent(nums1, set2);
            } else {
                list = getNumbersNotPresent(nums2, set1);
            }
            result.add(list);
        }

        return result;
    }

    private List<Integer> getNumbersNotPresent(int[] nums, boolean[] set) {
        List<Integer> result = new ArrayList<>();
        for (int number: nums) {
            if (!set[number + 1000]) {
                result.add(number);

                // 1. Prevent double-counting of number.
                set[number + 1000] = true;
            }
        }
        return result;
    }

    private boolean[] getSet(int[] nums) {
        boolean[] isNumberPresent = new boolean[2001];
        for (int number: nums) {
            isNumberPresent[number + 1000] = true;
        }
        return isNumberPresent;
    }
}