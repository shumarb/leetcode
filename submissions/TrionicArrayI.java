// Question:

class TrionicArrayOne {
    public boolean isTrionic(int[] nums) {
        int i = 0;
        int n = nums.length;

        if (n < 3) {
            return false;
        }

        // 1. Return false if there is no first increasing pattern or no next ascending pattern to check.
        while (i < n - 1 && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == 0 || i == n - 1) {
            return false;
        }

        // 2. Return false if there is no onlydecreasing pattern or no next ascending pattern to check.
        while (i < n - 1 && nums[i] > nums[i + 1]) {
            i++;
        }
        if (i == n - 1) {
            return false;
        }

        while (i < n - 1 && nums[i] < nums[i + 1]) {
            i++;
        }

        return i == n - 1;
    }
}