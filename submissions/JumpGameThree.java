// Question: https://leetcode.com/problems/jump-game-iii/description/

class JumpGameThree {
    public boolean canReach(int[] arr, int start) {
        // 1. Visited index marked as -1.
        if (start < 0 || start >= arr.length || arr[start] == -1) {
            return false;
        }

        if (arr[start] == 0) {
            return true;
        }

        int jump = arr[start];
        arr[start] = -1;

        return canReach(arr, start + jump) || canReach(arr, start - jump);
    }
}
