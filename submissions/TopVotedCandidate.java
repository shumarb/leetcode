// Question: https://leetcode.com/problems/online-election/description/

class TopVotedCandidate {
    private TreeMap<Integer, int[]> recentVoteMap;
    private TreeMap<Integer, int[]> votesMap;
    private boolean isTest;
    private int[] recentVote;
    private int[] votes;

    public TopVotedCandidate(int[] persons, int[] times) {
        int largest = 0;
        int n = persons.length;
        isTest = false;
        recentVoteMap = new TreeMap<>();
        votesMap = new TreeMap<>();

        for (int e: persons) {
            largest = Math.max(e, largest);
        }
        recentVote = new int[largest + 1];
        votes = new int[largest + 1];

        Arrays.fill(recentVote, -1);
        for (int i = 0; i < persons.length; i++) {
            int[] cloneRecentVote = new int[largest + 1];
            int[] cloneVotes = new int[largest + 1];
            int time = times[i];

            recentVote[persons[i]] = time;
            votes[persons[i]]++;
            for (int j = 0; j < recentVote.length; j++) {
                cloneRecentVote[j] = recentVote[j];
            }
            for (int j = 0; j < votes.length; j++) {
                cloneVotes[j] = votes[j];
            }
            recentVoteMap.put(time, cloneRecentVote);
            votesMap.put(time, cloneVotes);
        }
        if (isTest) {
            print();
            System.out.println("-------------------------");
        }
    }

    public int q(int t) {
        Map.Entry<Integer, int[]> floor = recentVoteMap.floorEntry(t);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[1], a[1]) == 0
                        ? Integer.compare(b[0], a[0])
                        : Integer.compare(b[1], a[1])
        );
        int latestTime = floor.getKey();
        int[] recentVoteValues = floor.getValue();
        int[] votesAtTime = votesMap.get(latestTime);

        if (isTest) {
            System.out.println("t: " + t + "\n * latestTime: " + latestTime + ", recentVoteValues: " + Arrays.toString(recentVoteValues) + ", votesAtTime: " + Arrays.toString(votesAtTime));
        }

        for (int i = 0; i < votes.length; i++) {
            if (recentVoteValues[i] != -1) {
                maxHeap.add(new int[] {recentVoteValues[i], votesAtTime[i], i});
            }
        }
        if (isTest) {
            System.out.println("\nmaxHeap:");
            for (int[] e: maxHeap) {
                System.out.println(" * " + Arrays.toString(e));
            }
        }

        int result = maxHeap.isEmpty() ? -1 : maxHeap.peek()[2];
        if (isTest) {
            System.out.println("\nresult: " + result);
            System.out.println("-------------------------");
        }

        return result;
    }

    private void print() {
        System.out.println("votesMap:");
        for (int key: votesMap.keySet()) {
            System.out.println(" * " + key + ": " + Arrays.toString(votesMap.get(key)));
        }
        System.out.println("\nrecentVoteMap:");
        for (int key: recentVoteMap.keySet()) {
            System.out.println(" * " + key + ": " + Arrays.toString(recentVoteMap.get(key)));
        }
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
