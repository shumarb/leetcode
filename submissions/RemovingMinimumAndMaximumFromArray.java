// Question: https://leetcode.com/problems/removing-minimum-and-maximum-from-array/description/

class RemovingMinimumAndMaximumFromArray {
        boolean isTest = false;
        int leftMost = 0;
        int len = nums.length;
        int maxIndex = 0;
        int minIndex = 0;
        int option1 = 0;
        int option2 = 0;
        int option3 = 0;
        int rightMost = 0;

        /**
         1.  Edge case: nums has <= 2 elements,
             so minimum number of moves is all elements.
         */
        if (len <= 2) {
            return len;
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            } else if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
        }
        leftMost = Math.min(maxIndex, minIndex);
        rightMost = Math.max(maxIndex, minIndex);
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nmaxIndex: " + maxIndex + "\nminIndex: " + minIndex);
            System.out.println("-------------------------------------------------------------");
            System.out.println("leftMost: " + leftMost + "\nrightMost: " + rightMost);
        }

        // 2. Remove from left.
        option1 = rightMost + 1;

        // 3. Remove from right.
        option2 = len - leftMost;

        // 4. Remove one by one (left followed by right, or right followed by left).
        option3 = (leftMost + 1) + (len - rightMost);

        return Math.min(option1, Math.min(option2, option3));
    }
}