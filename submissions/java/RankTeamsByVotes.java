// Question: https://leetcode.com/problems/rank-teams-by-votes/description/?envType=problem-list-v2&envId=counting

class RankTeamsByVotes {
    public String rankTeams(String[] votes) {
        StringBuilder result = new StringBuilder();
        Map<Character, int[]> map = new HashMap<>();
        boolean isTest = false;
        int numberOfTeams = votes[0].length();

        for (char letter: votes[0].toCharArray()) {
            map.put(letter, new int[numberOfTeams]);
        }
        if (isTest) {
            System.out.println("votes: " + Arrays.toString(votes));
            display("before, map: ", map);
            System.out.println("------------------------------------------------------------------------");
        }
        for (String vote: votes) {
            for (int i = 0; i < vote.length(); i++) {
                map.get(vote.charAt(i))[i]++;
            }
        }
        if (isTest) {
            display("after, map: ", map);
            System.out.println("------------------------------------------------------------------------");
        }

        List<Character> list = new ArrayList<>(map.keySet());
        list.sort(
                (a, b) -> {
                    for (int i = 0; i < numberOfTeams; i++) {
                        // 1. Sort by descending order of vote count.
                        if (map.get(a)[i] != map.get(b)[i]) {
                            return Integer.compare(map.get(b)[i], map.get(a)[i]);
                        }
                    }
                    return Character.compare(a, b);
                }
        );
        for (char letter: list) {
            result.append(letter);
        }
        if (isTest) {
            System.out.println("list: " + list);
            System.out.println("result: " + result.toString());
        }

        return result.toString();
    }

    private void display(String sentence, Map<Character, int[]> map) {
        System.out.println(sentence);
        for (Map.Entry<Character, int[]> entry: map.entrySet()) {
            System.out.println(" * " + entry.getKey() + " --> " + Arrays.toString(entry.getValue()));
        }
    }
}