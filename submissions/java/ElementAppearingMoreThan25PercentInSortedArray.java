// Question: https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/description/

class ElementAppearingMoreThan25PercentInSortedArray {
    public int findSpecialInteger(int[] arr) {
        int len = arr.length;
        for (int i = 0; i <= 3 * len / 4; i++) {
            if (arr[i] == arr[i + len / 4]) {
                return arr[i];
            }
        }
        return -1;
    }
}