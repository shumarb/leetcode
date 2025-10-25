// Question: https://leetcode.com/problems/longest-mountain-in-array/description/

class LongestMountainInArray {
    public int longestMountain(int[] arr) {
        int longest = 0;
        int n = arr.length;

        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;

                while (left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                }
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                longest = Math.max(longest, right - left + 1);
                i = right;
            }
        }

        return longest;
    }
}