// Question: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/

class CountNegativeNumbersInASortedMatrix {
    private boolean t = false;

    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] arr = grid[i];
            if (t) {
                System.out.println("arr: " + Arrays.toString(arr));
            }
            count += countNegative(arr);
        }

        return count;
    }

    private int countNegative(int[] arr) {
        int count = 0;
        int low = 0;
        int high = arr.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (t) {
                System.out.println("index    | " + low + ", " + mid + ", " + high);
                System.out.println("elements | " + arr[low] + ", " + arr[mid] + ", " + arr[high]);
            }
            if (arr[mid] >= 0) {
                low = mid + 1;
            } else {
                index = mid;
                high = mid - 1;
            }
        }
        if (t) {
            System.out.println("first negative index: " + index);
        }
        return (index == -1) ? 0 : arr.length - index;
    }
}