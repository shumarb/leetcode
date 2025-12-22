// Question: https://leetcode.com/problems/count-unhappy-friends/description/

class CountUnhappyFriends {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        boolean isTest = false;
        int[] partner = new int[n];
        int[][] rank = new int[n][n];
        int result = 0;

        for (int i = 0; i < preferences.length; i++) {
            int[] preference = preferences[i];
            int k = n - 1;
            for (int e: preference) {
                rank[i][e] = k--;
            }
        }
        for (int[] pair: pairs) {
            partner[pair[0]] = pair[1];
            partner[pair[1]] = pair[0];
        }
        if (isTest) {
            System.out.println("partner: " + Arrays.toString(partner));
            display("rank: ", rank);
        }

        for (int x = 0; x < n; x++) {
            int y = partner[x];
            for (int u: preferences[x]) {
                if (u == y) {
                    break;
                }
                int v = partner[u];
                if (rank[u][x] > rank[u][v]) {
                    result++;
                    break;
                }
            }
        }
        if (isTest) {
            System.out.println("----------------------------\nresult: " + result);
        }

        return result;
    }

    private void display(String s, int[][] rank) {
        System.out.println(s);
        for (int[] e: rank) {
            System.out.println(Arrays.toString(e));
        }
        System.out.println("----------------------------");
    }
}