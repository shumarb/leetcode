// Question: https://leetcode.com/problems/find-median-from-data-stream/description/

class MedianFinder {
    /**
         1. Max heap contains all elements <= median, and min heap contains all elements > median
         At all times, median will involve top element of max heap of top elements of both heaps.
     */
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    private boolean isTest = false;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        /**
            2. Set max heap (elements <= median) to contain the median if there are odd-numbered of elements inserted.
         */
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        /**
         3.  Redistribute elements such that if there are odd-numbered of elements,
             the max heap (elements <= median) contains 1 more element than min heap (elements > median),
             hence ensuring median when odd-numbered of elements are inserted is root of max heap.
         */
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }

        if (isTest) {
            displayHeaps();
        }
    }

    public double findMedian() {
        if (isTest) {
            displayHeaps();
        }

        /**
         4.  Even number of elements in data stream, so median
             is average of sum of its 2 middle elements, which are
             top elements in both heaps.
         */
        if (minHeap.size() == maxHeap.size()) {
            return ((double) minHeap.peek() + (double) maxHeap.peek()) / 2.0;
        }

        return (double) maxHeap.peek();
    }

    private void displayHeaps() {
        System.out.println("maxHeap: " + maxHeap);
        System.out.println("minHeap: " + minHeap);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */