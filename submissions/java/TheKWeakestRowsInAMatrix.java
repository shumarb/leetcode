// Question: https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/description/

class TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        boolean isTest = false;
        int[] result = new int[k];
        int[] soldiersPerRow = new int[mat.length];

        for (int i = 0; i < mat.length; i++) {
            int[] row = mat[i];
            int countSoldiers = 0;
            for (int element: row) {
                if (element == 1) {
                    countSoldiers++;
                }
            }
            soldiersPerRow[i] = countSoldiers;
        }
        if (isTest) {
            System.out.println("mat:");
            for (int[] row: mat) {
                System.out.println(" * " + Arrays.toString(row));
            }
            System.out.println();
            System.out.println("soldiers: " + Arrays.toString(soldiersPerRow));
            System.out.println();
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[1], a[1]) == 0 ? Integer.compare(b[0], a[0]) : Integer.compare(b[1], a[1])
        );
        for (int i = 0; i < soldiersPerRow.length; i++) {
            maxHeap.offer(new int[] {i, soldiersPerRow[i]});
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        if (isTest) {
            System.out.println("max heap:");
            for (int[] entry: maxHeap) {
                System.out.println(" * " + Arrays.toString(entry));
            }
            System.out.println();
        }

        int i = k - 1;
        while (!maxHeap.isEmpty()) {
            result[i--] = maxHeap.poll()[0];
        }
        if (isTest) {
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }
}