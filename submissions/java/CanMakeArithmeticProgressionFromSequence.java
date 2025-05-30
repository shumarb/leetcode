// Question: https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/description/

class CanMakeArithmeticProgressionFromSequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        arr = sort(arr);
        int difference = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != difference) {
                return false;
            }
        }
        return true;
    }

    private int[] sort(int[] arr) {
        int[] frequency = new int[2000001];
        int j = 0;
        for (int number: arr) {
            frequency[number + 1000000]++;
        }
        for (int i = 0; i < frequency.length; i++) {
            while (frequency[i]-- > 0) {
                arr[j++] = i - 1000000;
            }
        }
        return arr;
    }
}