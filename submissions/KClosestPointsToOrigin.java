// Question: https://leetcode.com/problems/k-closest-points-to-origin/description/

class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        List<Pair> list = new ArrayList<>();
        boolean isTest = false;

        for (int[] point: points) {
            double sumOfSquares = Math.pow((double) point[0], 2.0) + Math.pow((double) point[1], 2.0);
            list.add(new Pair(point, Math.sqrt(sumOfSquares)));
        }
        list.sort((a, b) -> Double.compare(a.getEuclideanDistance(), b.getEuclideanDistance()));
        if (isTest) {
            System.out.println("list:");
            for (Pair pair: list) {
                System.out.println(" * " + Arrays.toString(pair.getPoint()) + " --> " + pair.getEuclideanDistance());
            }
            System.out.println("----------------------------------------------------------------------");
        }

        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getPoint();
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