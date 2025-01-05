// Question: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/

class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<> (Collections.reverseOrder());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int num = matrix[i][j];
                if (maxHeap.size() < k) {
                    maxHeap.offer(num);
                } else {
                    if (num < maxHeap.peek()) {
                        maxHeap.poll();
                        maxHeap.offer(num);
                    }
                }
            }
        }
        return maxHeap.peek();
    }

}
