// Question: https://leetcode.com/problems/find-target-indices-after-sorting-array/description/

class FindTargetIndicesAfterSortingArray {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        boolean isTest = false;
        int[] count = new int[101];
        int firstIndex = -1;
        int j = 0;
        int lastIndex = -1;
        int left = 0;
        int n = nums.length;
        int right = n - 1;

        for (int e: nums) {
            count[e]++;
        }
        for (int i = 1; i < count.length; i++) {
            while (count[i]-- > 0) {
                nums[j++] = i;
            }
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int key = nums[mid];

            if (key >= target) {
                right = mid - 1;

                if (key == target) {
                    firstIndex = mid;
                }

            } else {
                left = mid + 1;
            }
        }

        left = 0;
        right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int key = nums[mid];

            if (key <= target) {
                left = mid + 1;

                if (key == target) {
                    lastIndex = mid;
                }

            } else {
                right = mid - 1;
            }
        }
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums) + "\n\ntarget: " + target + ", index range: [" + firstIndex + ", " + lastIndex + "]");
        }

        if (firstIndex == -1) {
            return result;
        }

        for (int i = firstIndex; i <= lastIndex; i++) {
            result.add(i);
        }
        if (isTest) {
            System.out.println("\nresult: " + result);
        }

        return result;
    }
}
