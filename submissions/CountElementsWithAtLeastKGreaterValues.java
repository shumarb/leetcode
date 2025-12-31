// Question: https://leetcode.com/problems/count-elements-with-at-least-k-greater-values/description/

class CountElementsWithAtLeastKGreaterValues {
    public int countElements(int[] nums, int k) {
        int i = 0;
        int n = nums.length;
        int result = 0;

        Arrays.sort(nums);
        while (i < n) {
            int j = i;

            // 1. Find block of duplicates.
            while (j < n && nums[j] == nums[i]) {
                j++;
            }

            /**
             2.  If number of elements greater than i-th element > k,
                 increase result by number of elements in block.
             */
            if (n - j >= k) {
                result += (j - i);
            }

            // 3. Start at element after current block.
            i = j;
        }

        return result;
    }
}