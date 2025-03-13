// Question: https://leetcode.com/problems/k-th-smallest-prime-fraction/description/

class KthSmallestPrimeFaction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Double.compare(b[2], a[2])
        );
        boolean isTest = false;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                maxHeap.offer(new double[] {arr[i], arr[j], (double) arr[i] / (double) arr[j]});
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        if (isTest) {
            System.out.println("max heap:");
            for (double[] entry: maxHeap) {
                System.out.println(" * n: " + entry[0] + ", d: " + entry[1] + ", value: " + entry[2]);
            }
        }

        return new int[] {(int) maxHeap.peek()[0], (int) maxHeap.peek()[1]};
    }
}