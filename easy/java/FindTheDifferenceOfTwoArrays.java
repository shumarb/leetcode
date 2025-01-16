// Question: https://leetcode.com/problems/find-the-difference-of-two-arrays/description/

class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<> ();
        Set<Integer> set1 = new HashSet<> ();
        Set<Integer> set2 = new HashSet<> ();
        boolean t = false;

        populate(set1, nums1);
        populate(set2, nums2);
        if (t) {
            System.out.println("nums1: " + Arrays.toString(nums1) + ", nums2: " + Arrays.toString(nums2));
            System.out.println("set1: " + set1 + ", set2: " + set2);
        }

        for (int i = 0; i < 2; i++) {
            List<Integer> notPresent;
            if (i == 0) {
                notPresent = getNotPresent(nums1, set2);
            } else {
                notPresent = getNotPresent(nums2, set1);
            }
            if (t) {
                System.out.println("notPresent: " + notPresent);
            }
            ans.add(notPresent);
        }
        return ans;
    }

    private List<Integer> getNotPresent(int[] n, Set<Integer> s) {
        List<Integer> list = new ArrayList<>();
        for (int x: n) {
            if (!s.contains(x) && !list.contains(x)) {
                list.add(x);
            }
        }
        return list;
    }

    private void populate(Set<Integer> s, int[] n) {
        for (int x: n) {
            s.add(x);
        }
    }
}