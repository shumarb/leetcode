// Question: https://leetcode.com/problems/longest-mountain-in-array/description/

class LongestMountainInArray {
    public int longestMountain(int[] arr) {
        boolean isTest = false;
        int longest = 0;
        int n = arr.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        /**
         1.  If every element is the peak of mountain,
             count the number of valid elements to its left and right.
             Start from 1st and penultimate elements for respective arrays
             because first and last elements are never the peak of a mountain.
         */
        for (int i = 1; i < n; i++) {
            prefix[i] = arr[i] > arr[i - 1] ? 1 + prefix[i - 1] : 0;
        }
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = arr[i] > arr[i + 1] ? 1 + suffix[i + 1] : 0;
        }

        /**
         2.  If each element is a the peak of a mountain,
             the number of valid elements to its left and right are each > 0,
             so count the number of elements included in this mountain
             (+ 1 to include current element which is the peak).
         */
        for (int i = 1; i < n - 1; i++) {
            if (prefix[i] > 0 && suffix[i] > 0) {
                longest = Math.max(longest, 1 + prefix[i] + suffix[i]);
            }
        }
        if (isTest) {
            System.out.println("arr:    " + Arrays.toString(arr) + "\nprefix: " + Arrays.toString(prefix));
            System.out.println("suffix: " + Arrays.toString(suffix) + "\n-------------------------------\nlongest: " + longest);
        }

        return longest;
    }
}