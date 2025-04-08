// Question: https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/description/

class ElementAppearingMoreThan25PercentInSortedArray {
    public int findSpecialInteger(int[] arr) {
        int len = arr.length;
        int start = 0;
        while (start < len) {
            int count = 1;
            int end = start + 1;
            while (end < len && arr[end] == arr[start]) {
                end++;
            }
            if ((end - start) > len / 4) {
                return arr[start];
            }
            start = end;
        }
        return -1;
    }
}