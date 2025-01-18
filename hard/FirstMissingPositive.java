// Question: https://leetcode.com/problems/first-missing-positive/description/

class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        boolean t = false;
        if (t) {
            System.out.println("before - nums: " + Arrays.toString(nums));
        }
        while (i < n) {
            int currElem = nums[i];
            int correctIndex = currElem - 1;
            if (t) {
                System.out.println("currElem: " + currElem + ", correctIndex: " + correctIndex);
            }
            if (currElem > 0 && currElem <= n && currElem != nums[correctIndex]) {
                if (t) {
                    System.out.println("swap at indices: " + i + " & " + correctIndex);
                }
                swap(nums, i, correctIndex);
                if (t) {
                    System.out.println("after swap, - nums so far: " + Arrays.toString(nums));
                }
            } else {
                i++;
            }
        }

        if (t) {
            System.out.println("after - nums: " + Arrays.toString(nums));
            System.out.println("---------------------------------------------------");
        }
        for (i = 1; i <= n; i++) {
            if (t) {
                System.out.println("checking value: " + i + " at index " + (i - 1));
            }
            if (nums[i - 1] != i) {
                return i;
            }
        }

        // elements sorted in consecutive increasing order
        // so return 1 + last element
        return n + 1;
    }

    private void swap(int[] n, int i, int c) {
        int temp = n[i];
        n[i] = n[c];
        n[c] = temp;
    }
}