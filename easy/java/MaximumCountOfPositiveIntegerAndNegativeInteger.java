// Question: https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/

class MaximumCountOfPositiveIntegerAndNegativeInteger {
    private boolean t = false;

    public int maximumCount(int[] nums) {
        int indexP = getFirstP(nums);
        int indexN = getLastN(nums);
        int countP = (indexP == -1 ? 0 : nums.length - indexP);
        int countN = (indexN == -1 ? 0 : indexN + 1);
        return Math.max(countP, countN);
    }

    private int getLastN(int[] a) {
        int index = -1;
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (t) {
                System.out.println("indices: " + low + ", " + mid + ", " + high);
                System.out.println("elements: " + a[low] + ", " + a[mid] + ", " + a[high]);
            }
            if (a[mid] >= 0) {
                high = mid - 1;
            } else {
                // current element is negative but may not be last negative
                // so take not of its index and search for negative element in indices [mid + 1, high]
                index = mid;
                low = mid + 1;
            }
        }

        if (t) {
            System.out.println("last negative index: " + index);
        }
        return index;
    }

    private int getFirstP(int[] a) {
        int low = 0;
        int high = a.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (t) {
                System.out.println("indices: " + low + ", " + mid + ", " + high);
                System.out.println("elements: " + a[low] + ", " + a[mid] + ", " + a[high]);
            }
            if (a[mid] <= 0) {
                low = mid + 1;
            } else {
                // current element is positive but it's index may not be first positive
                // so take note of index and search for first positive in index [low, mid - 1]
                index = mid;
                high = mid - 1;
            }
        }

        if (t) {
            System.out.println("first positive index: " + index);
        }
        return index;
    }
}