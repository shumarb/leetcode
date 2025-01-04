class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                minHeap.offer(matrix[i][j]);
            }
        }
        int kSmallest = 0;
        for (int i = 0; i < k; i++) {
            kSmallest = minHeap.poll();
        }
        return kSmallest;
    }
    
}
