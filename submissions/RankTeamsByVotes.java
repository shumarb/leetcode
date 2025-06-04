// Question: https://leetcode.com/problems/rank-teams-by-votes/description/?envType=problem-list-v2&envId=counting

class RankTeamsByVotes {
    public String rankTeams(String[] votes) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;
        int numTeams = votes[0].length();
        int[][] map = new int[26][numTeams + 1];

        for (int i = 0; i < 26; i++) {
            map[i][0] = i;
        }
        for (String vote: votes) {
            for (int i = 0; i < vote.length(); i++) {
                map[vote.charAt(i) - 'A'][i + 1]++;
            }
        }
        Arrays.sort(
                map, (a, b) -> {
                    for (int i = 1; i < numTeams + 1; i++) {
                        if (b[i] > a[i]) {
                            // 1. b comes before a.
                            return 1;
                        } else if (b[i] < a[i]) {
                            // 2. a comes before b.
                            return -1;
                        }
                    }
                    return 0;
                }
        );
        for (int i = 0; i < numTeams; i++) {
            result.append((char) ('A' + map[i][0]));
        }
        if (isTest) {
            System.out.println("votes: " + Arrays.toString(votes));
            display("map:", map);
            System.out.println("result: " + result.toString());
        }
        return result.toString();
    }

    private void display(String sentence, int[][] map) {
        System.out.println(sentence);
        for (int[] row: map) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("----------------------------------------------------");
    }
}