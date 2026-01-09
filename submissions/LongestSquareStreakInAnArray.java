// Question: https://leetcode.com/problems/longest-square-streak-in-an-array/description/

class LongestSquareStreakInAnArray {
    public int longestSquareStreak(int[] nums) {
        Set<Long> set = new HashSet<>();
        boolean isTest = false;
        int largest = 0;
        int longest = -1;
        int n = nums.length;
        long[] arr = new long[n];

        for (int e: nums) {
            largest = Math.max(e, largest);
        }
        nums = sort(nums, largest);
        for (int i = 0; i < n; i++) {
            arr[i] = (long) nums[i];
        }
        for (int i = 0; i < n; i++) {
            int e = nums[i];
            long key = arr[i];
            if (set.contains(key)) {
                continue;
            }
            if (isTest) {
                System.out.println("----------------------------------\ne: " + key);
            }

            int len = 1;
            set.add(key);
            key *= key;
            while (Arrays.binarySearch(arr, key) >= 0) {
                if (isTest) {
                    System.out.println(" * present: " + key);
                }
                set.add(key);
                key *= key;
                len++;
            }
            if (len >= 2) {
                if (isTest) {
                    System.out.println("start with " + e + " -> len of " + len);
                }
                longest = Math.max(len, longest);
            }
        }
        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums) + "\nlongest: " + longest);
        }

        return longest;
    }

    private int[] sort(int[] arr, int largest) {
        int[] count = new int[largest + 1];
        int j = 0;

        for (int e: arr) {
            count[e]++;
        }
        for (int i = 2; i <= largest; i++) {
            while (count[i]-- > 0) {
                arr[j++] = i;
            }
        }

        return arr;
    }
}