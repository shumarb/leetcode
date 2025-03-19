// Question: https://leetcode.com/problems/find-players-with-zero-or-one-losses/description/

class FindPlayersWithZeroOrOneLosses {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> result = new ArrayList<>();
        int maximum = -1;
        boolean isTest = false;

        for (int[] match: matches) {
            for (int element: match) {
                maximum = Math.max(maximum, element);
            }
        }

        int[] losses = new int[maximum + 1];
        int[] numberOfMatchesPlayed = new int[maximum + 1];
        for (int[] match: matches) {
            losses[match[1]]++;
            numberOfMatchesPlayed[match[0]]++;
            numberOfMatchesPlayed[match[1]]++;
        }
        if (isTest) {
            System.out.println("matches:");
            for (int[] row: matches) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("number of matches played: ");
            for (int i = 1; i < numberOfMatchesPlayed.length; i++) {
                System.out.println(" * player " + i + ": " + numberOfMatchesPlayed[i] + " matches.");
            }
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("losses: ");
            for (int i = 1; i < losses.length; i++) {
                System.out.println(" * player " + i + ": " + losses[i] + " losses.");
            }
            System.out.println("-------------------------------------------------------------------------");
        }

        for (int i = 0; i < 2; i++) {
            List<Integer> players = new ArrayList<>();
            for (int j = 1; j < losses.length; j++) {
                if (numberOfMatchesPlayed[j] > 0 && losses[j] == i) {
                    players.add(j);
                }
            }
            result.add(players);
        }
        if (isTest) {
            System.out.println("result:");
            System.out.println("players with 0 losses: " + result.get(0));
            System.out.println("players with 1 loss: " + result.get(1));
        }

        return result;
    }
}