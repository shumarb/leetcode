// Question: https://leetcode.com/problems/minimum-common-value/description/

class MinimumCommonValue {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        boolean t = false;

        populate(s1, nums1);
        populate(s2, nums2);
        if (t) {
            System.out.println("nums1: " + Arrays.toString(nums1) + ", nums2: " + Arrays.toString(nums2));
            System.out.println("s1: " + s1 + ", s2: " + s2);
        }
        List<Integer> common = new ArrayList<> ();
        Set<Integer> counted = new HashSet<> ();
        findCommon(counted, common, nums1, s2);
        findCommon(counted, common, nums2, s1);
        if (t) {
            System.out.println("common: " + common);
        }

        return common.isEmpty() ? -1 : common.get(0);
    }

    private void findCommon(Set<Integer> counted, List<Integer> com, int[] n, Set<Integer> s) {
        for (int x: n) {
            if (s.contains(x) && !counted.contains(x)) {
                com.add(x);
                counted.add(x);
            }
        }
    }

    private void populate(Set<Integer> s, int[] n) {
        for (int x: n) {
            s.add(x);
        }
    }
}