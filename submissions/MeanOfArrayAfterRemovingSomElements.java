// Question: https://leetcode.com/problems/mean-of-array-after-removing-some-elements/description/

class MeanOfArrayAfterRemovingSomElements {
    public double trimMean(int[] arr) {
        int len = arr.length;
        int k = (int) (0.05 * (double) len);
        boolean isTest = false;
        if (isTest) {
            System.out.println("arr: " + Arrays.toString(arr) + ", len: " + len + ", k: " + k);
        }

        PriorityQueue<Double> minHeap = new PriorityQueue<>();
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;
        for (int number: arr) {
            double value = number;
            sum += value;
            minHeap.offer(value);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            maxHeap.offer(value);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        if (isTest) {
            System.out.println("minHeap: " + minHeap + ", maxHeap: " + maxHeap + ", sum: " + sum);
        }

        double denominator = (double) (len - minHeap.size() - maxHeap.size());
        while (!minHeap.isEmpty()) {
            sum -= minHeap.poll();
        }
        while (!maxHeap.isEmpty()) {
            sum -= maxHeap.poll();
        }
        if (isTest) {
            System.out.println("updated sum: " + sum + ", denominator: " + denominator);
        }
        return sum / denominator;
    }
}