// Question: https://leetcode.com/problems/maximum-sum-with-at-most-k-elements/description/

class MaximumSumWithAtMostKElements {
    public long maxSum(int[][] grid, int[] limits, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        boolean isTest = false;
        int m = grid.length;
        int n = grid[0].length;
        long result = 0;

        for (int i = 0; i < m; i++) {
            int limit = limits[i];
            grid[i] = sort(grid[i]);
            for (int j = n - 1; j >= 0 && limit > 0; j--) {
                result += grid[i][j];
                minHeap.offer(grid[i][j]);
                if (minHeap.size() > k) {
                    result -= minHeap.poll();
                }
                limit--;
            }
        }
        if (isTest) {
            System.out.println("min heap: " + minHeap + "\nresult: " + result);
        }

        return result;
    }

    private int[] sort(int[] arr) {
        int[] frequency;
        int j = 0;
        int largest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            largest = Math.max(arr[i], largest);
        }
        frequency = new int[largest + 1];

        for (int number: arr) {
            frequency[number]++;
        }

        for (int i = 0; i <= largest; i++) {
            while (frequency[i]-- > 0) {
                arr[j++] = i;
            }
        }

        return arr;
    }
}