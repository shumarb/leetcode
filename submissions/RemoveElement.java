// Question: https://leetcode.com/problems/remove-element/description/

class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int x: nums) {
            if (x != val) {
                nums[k++] = x;
            }
        }
        return k;
    }
}