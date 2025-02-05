// Question: https://leetcode.com/problems/relative-ranks/description/

class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] answer = new String[n];
        int maximumScore = getMaximumScore(score);
        int[] scoreIndex = new int[maximumScore + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        boolean isTest = false;

        for (int i = 0; i < n; i++) {
            maxHeap.offer(score[i]);
            scoreIndex[score[i]] = i;
        }
        if (isTest) {
            System.out.println("score: " + Arrays.toString(score) + "\nmaxHeap: " + maxHeap + "\nscoreIndex: " + Arrays.toString(scoreIndex));
        }

        int count = 0;
        while (!maxHeap.isEmpty()) {
            int root = maxHeap.poll();
            int index = scoreIndex[root];
            count++;
            if (isTest) {
                System.out.println("root: " + root + ", index: " + index + ", count: " + count);
            }
            if (count == 1) {
                answer[index] = "Gold Medal";
            } else if (count == 2) {
                answer[index] = "Silver Medal";
            } else if (count == 3) {
                answer[index] = "Bronze Medal";
            } else {
                answer[index] = String.valueOf(count);
            }
        }

        if (isTest) {
            System.out.println("answer: " + Arrays.toString(answer));
        }
        return answer;
    }

    private int getMaximumScore(int[] score) {
        int maximumScore = score[0];
        for (int element: score) {
            maximumScore = Math.max(element, maximumScore);
        }
        return maximumScore;
    }
}
