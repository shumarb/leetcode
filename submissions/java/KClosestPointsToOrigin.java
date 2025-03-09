// Question: https://leetcode.com/problems/k-closest-points-to-origin/description/

class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
                (a, b) -> Double.compare(b.getEuclideanDistance(), a.getEuclideanDistance())
        );
        boolean isTest = false;

        for (int[] point: points) {
            double sumOfSquares = Math.pow((double) point[0], 2.0) + Math.pow((double) point[1], 2.0);
            minHeap.offer(new Pair(point, Math.sqrt(sumOfSquares)));
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        if (isTest) {
            System.out.println("min heap:");
            for (Pair pair: minHeap) {
                System.out.println(" * " + Arrays.toString(pair.getPoint()) + " --> " + pair.getEuclideanDistance());
            }
            System.out.println("----------------------------------------------------------------------");
        }

        int i = k - 1;
        while (!minHeap.isEmpty()) {
            result[i--] = minHeap.poll().getPoint();
        }
        if (isTest) {
            System.out.println("result:");
            for (int[] row: result) {
                System.out.println(" * " + Arrays.toString(row));
            }
        }

        return result;
    }
}

class Pair {
    private int[] point;
    private double euclideanDistance;

    public Pair(int[] point, double euclideanDistance) {
        this.point = point;
        this.euclideanDistance = euclideanDistance;
    }

    public int[] getPoint() {
        return point;
    }

    public double getEuclideanDistance() {
        return euclideanDistance;
    }
}