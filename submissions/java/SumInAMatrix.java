// Question: https://leetcode.com/problems/sum-in-a-matrix/description/

class SumInAMatrix {
    public int matrixSum(int[][] nums) {
        int highestValue = 0;
        int numCols = nums[0].length;
        boolean isTest = false;
        List<PriorityQueue<Integer>> list = new ArrayList<>();

        for (int[] row: nums) {
            PriorityQueue<Integer> rowValues = new PriorityQueue<>(Collections.reverseOrder());
            for (int element: row) {
                rowValues.offer(element);
            }
            list.add(rowValues);
        }
        if (isTest) {
            display(list);
        }

        for (int i = 0; i < numCols; i++) {
            int maximum = Integer.MIN_VALUE;
            if (isTest) {
                System.out.print("start of iteration | highest value: " + highestValue + " | ");
                display(list);
            }
            for (PriorityQueue<Integer> maxHeap: list) {
                maximum = Math.max(maximum, maxHeap.poll());
            }
            highestValue += maximum;
        }

        return highestValue;
    }

    private void display(List<PriorityQueue<Integer>> list) {
        System.out.println("list:");
        for (PriorityQueue<Integer> maxHeap: list) {
            System.out.println(" * " + maxHeap);
        }
        System.out.println("-------------------------------------------------");
    }
}