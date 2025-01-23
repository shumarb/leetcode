// Question: https://leetcode.com/problems/find-the-duplicate-number/description/

class FindTheDuplicateElement {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        /**
         1.  Iterate using fast and slow pointers.
         Given elements are in range [1, n], and array has n + 1 elements,
         the element can be used to access an index.
         Fast pointer moves twice as fast as the slow pointer.
         Keep iterating until both pointers meet at same element.
         */
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        /**
         2.  Move both pointers at same speed until both point to same element
         fast = element of duplicate, and slow is set to 0,
         so iterate both one by one,
         where fast starts from duplicate element,
         and slow starts from first element.
         both pointers iterate one by one until they both meet,
         hence they both point to duplicate element.
         */
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}