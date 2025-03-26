// Question: https://leetcode.com/problems/find-the-difference-of-two-arrays/description/

class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set1 = getNumbersInArray(nums1);
        Set<Integer> set2 = getNumbersInArray(nums2);

        for (int i = 0; i < 2; i++) {
            List<Integer> list;
            if (i == 0) {
                list = populate(set1, set2);
            } else {
                list = populate(set2, set1);
            }
            result.add(list);
        }

        return result;
    }

    private List<Integer> populate(Set<Integer> first, Set<Integer> second) {
        List<Integer> result = new ArrayList<>();
        for (int number: first) {
            if (!second.contains(number)) {
                result.add(number);
            }
        }
        return result;
    }

    private Set<Integer> getNumbersInArray(int[] nums) {
        Set<Integer> result = new HashSet<>();
        for (int number: nums) {
            result.add(number);
        }
        return result;
    }
}