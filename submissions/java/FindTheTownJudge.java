// Question: https://leetcode.com/problems/find-the-town-judge/description/

class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        /** 1.  Create an array of (n + 1) elements (due to 1-based counting),
         where each index represents a vertex.
         */
        int[] trustCount = new int[n + 1];
        boolean isTest = false;

        /** 2.  Iterate all edges,
         for each edge [source --> destination],
         decrease value of source in trustCount by 1 to denote outgoing edge,
         and increase value of destination in trustCount by 1 to denote incoming edge,
         */
        for (int[] edge: trust) {
            trustCount[edge[0]]--;
            trustCount[edge[1]]++;
        }
        if (isTest) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("trust:");
            for (int[] edge: trust) {
                System.out.println(edge[0] + " --> " + edge[1]);
            }
            System.out.println();
            System.out.println("trustCount: " + Arrays.toString(trustCount));
            System.out.println("-----------------------------------------------------------");
        }

        /**
         3.  The town judge is the element with the value (n - 1),
         meaning it has 0 outgoing edges to indicate it trusts nobody,
         and (n - 1) incoming edges to indicate it is trusted by all except itself.
         */
        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == n - 1) {
                return i;
            }
        }

        // 4. No town judge exists.
        return -1;
    }
}