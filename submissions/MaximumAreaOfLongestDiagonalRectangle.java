// Question: https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/description/

class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        if (dimensions.length == 1) {
            return dimensions[0][0] * dimensions[0][1];
        }

        List<Dimension> list = new ArrayList<>();
        boolean isTest = false;

        for (int[] dimension: dimensions) {
            list.add(new Dimension(dimension[0], dimension[1]));
        }
        list.sort((a, b) -> Double.compare(b.diagonal, a.diagonal) == 0
                ? Integer.compare(b.area, a.area)
                : Double.compare(b.diagonal, a.diagonal)
        );
        if (isTest) {
            System.out.println("list:");
            for (Dimension e: list) {
                System.out.println("l: " + e.length + ", w: " + e.width + " -> d: " + e.diagonal + ", a: " + e.area);
            }
        }

        return list.get(0).area;
    }
}

class Dimension {
    int area;
    int length;
    int width;
    double diagonal;

    public Dimension(int length, int width) {
        this.area = length * width;
        this.diagonal = Math.sqrt(length * length + width * width);
        this.length = length;
        this.width = width;
    }
}