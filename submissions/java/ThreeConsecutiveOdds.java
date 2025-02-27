// Question: https://leetcode.com/problems/three-consecutive-odds/description/

class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        // 1. Edge case: array has < 3 elements, so answer is false
        if (arr.length < 3) {
            return false;
        }

        for (int i = 0; i < arr.length - 2; i++) {
            if (isOdd(arr[i]) && isOdd(arr[i + 1]) && isOdd(arr[i + 2])) {
                return true;
            }
        }

        return false;
    }

    private boolean isOdd(int number) {
        return number % 2 != 0;
    }
}