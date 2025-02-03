// Question: https://leetcode.com/problems/find-in-mountain-array/description/

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class FindInMountainArray {
    private boolean t = false;

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int maxIndex = findMaxIndex(mountainArr);
        if (t) {
            System.out.println("maxIndex: " + maxIndex);
        }

        int targetIndex1 = searchAscendingOrder(0, maxIndex, target, mountainArr);
        if (targetIndex1 != -1) {
            return targetIndex1;
        }

        return searchDescendingOrder(maxIndex + 1, mountainArr.length() - 1, target, mountainArr);
    }

    private int searchDescendingOrder(int start, int end, int target, MountainArray arr) {
        int index = -1;
        int low = start;
        int high = end;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (t) {
                System.out.println("indices | low: " + low + ", mid: " + mid + ", high: " + high);
                System.out.println("element | " + arr.get(low) + ", " + arr.get(mid) + ", " + arr.get(high));
            }
            if (arr.get(mid) <= target) {
                if (arr.get(mid) == target) {
                    index = mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return index;
    }

    private int searchAscendingOrder(int low, int high, int target, MountainArray arr) {
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (t) {
                System.out.println("indices | low: " + low + ", mid: " + mid + ", high: " + high);
                System.out.println("element | " + arr.get(low) + ", " + arr.get(mid) + ", " + arr.get(high));
            }
            if (arr.get(mid) >= target) {
                if (arr.get(mid) == target) {
                    index = mid;
                }
                if (t) {
                    System.out.println("update | targetIndex: " + index);
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return index;
    }

    private int findMaxIndex(MountainArray arr) {
        int maxIndex = -1;
        int low = 1;
        int high = arr.length() - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (t) {
                System.out.println("indices | low: " + low + ", mid: " + mid + ", high: " + high);
                System.out.println("element | " + arr.get(low) + ", " + arr.get(mid) + ", " + arr.get(high));
            }
            if (arr.get(mid) > arr.get(mid + 1)) {
                maxIndex = mid;
                high = mid - 1;
                if (t) {
                    System.out.println("update | maxIndex: " + maxIndex);
                }
            } else {
                low = mid + 1;
            }
        }

        return maxIndex;
    }
}