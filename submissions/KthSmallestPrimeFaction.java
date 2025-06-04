// Question: https://leetcode.com/problems/k-th-smallest-prime-fraction/description/

class KthSmallestPrimeFaction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Triple> maxHeap = new PriorityQueue<>(
                (a, b) -> Double.compare(b.getValue(), a.getValue())
        );

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                maxHeap.offer(new Triple(new int[] {arr[i], arr[j]}, (double) arr[i] / (double) arr[j]));
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }

        return maxHeap.peek().getPoint();
    }
}

class Triple {
    int[] point;
    double value;

    public Triple(int[] point, double value) {
        this.point = point;
        this.value = value;
    }

    public int[] getPoint() {
        return point;
    }

    public double getValue() {
        return value;
    }
}