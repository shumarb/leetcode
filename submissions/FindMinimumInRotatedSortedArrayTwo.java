// Question: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/

class FindMinimumInRotatedSortedArrayTwo {
    public int findMin(int[] nums) {
        boolean isTest = false;
        int left = 0;
        int n = nums.length;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isTest) {
                System.out.println(" * indices:  [" + left + ", " + mid + ", " + right + "]");
                System.out.println(" * elements: [" + nums[left] + ", " + nums[mid] + ", " + nums[right] + "]");
                System.out.println("-------------------------------------------------------");
            }

            /**
                1. Minimum is @ index after mid, so exclude all elements before mid.
             */
            if (nums[mid] > nums[right]) {
                left = mid + 1;

                /**
                 2.  Elements are the same, and we want the minimum element to be the found at the left index,
                     so reduce right by 1.
                 */
            } else if (nums[mid] == nums[right]) {
                right--;

                /**
                 3.  Mid-th element could be minimum, and it could also contain duplicates,
                     so exlude all elements after it by setting right as mid,
                     hence the minimum is in index range [left, mid].
                 */
            } else {
                right = mid;
            }
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nminimum: " + nums[left] + " @ index " + left);
        }

        return nums[left];
    }
}
