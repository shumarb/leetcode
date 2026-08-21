// Question: https://leetcode.com/problems/unique-middle-element/description/

class UniqueMiddleElement {
    public boolean isMiddleElementUnique(int[] nums) {
        int[] count = new int[101];
        int middleElement = nums[nums.length / 2];

        for (int e: nums) {
            count[e]++;
        }

        return count[middleElement] == 1;
    }
}
