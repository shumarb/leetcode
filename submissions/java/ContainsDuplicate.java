// Question: https://leetcode.com/problems/contains-duplicate/description/

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<> ();
        for (int element: nums) {
            if (!set.add(element)) {
                return true;
            }
        }
        return false;
    }
}
