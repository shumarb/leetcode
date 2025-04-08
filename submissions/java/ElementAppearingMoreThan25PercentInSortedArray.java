// Question: https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/description/

class ElementAppearingMoreThan25PercentInSortedArray {
    public int findSpecialInteger(int[] arr) {
        int maximum = arr[arr.length - 1];
        int[] numberFrequency = new int[maximum + 1];
        for (int number: arr) {
            numberFrequency[number]++;
            if (numberFrequency[number] > arr.length / 4) {
                return number;
            }
        }
        return -1;
    }
}