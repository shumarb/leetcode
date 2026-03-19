// Question: https://leetcode.com/problems/find-champion-ii/description/

class FindChampionTwo {
    public int findChampion(int n, int[][] edges) {
        boolean isTest = false;
        int[] incoming = new int[n];
        int countChampions = 0;

        for (int[] edge: edges) {
            incoming[edge[1]]--;
        }
        for (int i = 0; i < n; i++) {
            if (incoming[i] == 0 && ++countChampions > 1) {
                return -1;
            }
        }
        if (isTest) {
            System.out.println("incoming: " + Arrays.toString(incoming) + "\ncountChampions: " + countChampions);
        }

        for (int i = 0; i < n; i++) {
            if (incoming[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}