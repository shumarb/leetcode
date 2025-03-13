// Question: https://leetcode.com/problems/reward-top-k-students/description/

class RewardTopKStudents {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[1], a[1]) == 0 ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1])
        );
        boolean isTest = false;
        Set<String> positiveWords = new HashSet<>();
        Set<String> negativeWords = new HashSet<>();

        populate(positive_feedback, positiveWords);
        populate(negative_feedback, negativeWords);

        for (int i = 0; i < student_id.length; i++) {
            int id = student_id[i];
            int points = computePoints(report[i], positiveWords, negativeWords);
            minHeap.offer(new int[] {id, points});
        }
        if (isTest) {
            System.out.println("min heap:");
            for (int[] entry: minHeap) {
                System.out.println(" * id: " + entry[0] + " --> points: " + entry[1]);
            }
            System.out.println();
        }

        for (int i = 0; i < k; i++) {
            result.add(minHeap.poll()[0]);
        }
        if (isTest) {
            System.out.println("result: " + result);
        }
        return result;
    }

    private int computePoints(String report, Set<String> positiveWords, Set<String> negativeWords) {
        int points = 0;
        String[] reportWords = report.split(" ");
        for (String word: reportWords) {
            if (positiveWords.contains(word)) {
                points += 3;
            } else if (negativeWords.contains(word)) {
                points -= 1;
            }
        }
        return points;
    }

    private void populate(String[] feedback, Set<String> words) {
        for (String word: feedback) {
            words.add(word);
        }
    }
}