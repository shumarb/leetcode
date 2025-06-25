// Question: https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-i/description/

class MaximumNumberOfOperationsWithTheSameScoreOne {
    public int maxOperations(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        int countOperations = 0;
        int score = 0;

        for (int number: nums) {
            queue.offer(number);
        }
        while (queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();
            if (score == 0) {
                score = first + second;
            } else {
                if (first + second != score) {
                    break;
                }
            }
            countOperations++;
        }

        return countOperations;
    }
}