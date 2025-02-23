// Question: https://leetcode.com/problems/find-center-of-star-graph/description/

class FindCenterOfStarGraph {
    public int findCenter(int[][] edges) {
        int[] vertexDegree = new int[edges.length + 2];
        boolean isTest = false;

        for (int[] edge: edges) {
            vertexDegree[edge[0]]++;
            vertexDegree[edge[1]]++;
        }
        if (isTest) {
            display(vertexDegree, edges);
        }

        for (int i = 1; i < vertexDegree.length; i++) {
            if (vertexDegree[i] == edges.length) {
                return i;
            }
        }

        return 0;
    }

    private void display(int[] vertexDegree, int[][] edges) {
        System.out.println("----------------------------------------------");
        System.out.println();
        System.out.println("vertex degree: " + Arrays.toString(vertexDegree));
        System.out.println();
        System.out.println("edges:");
        for (int[] edge: edges) {
            System.out.println(Arrays.toString(edge));
        }
        System.out.println();
        System.out.println("----------------------------------------------");
    }
}