// Question: https://leetcode.com/problems/relative-ranks/description/

class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] answer = new String[n];
        Map<Integer, Integer> scoreIndexMap = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        boolean isTest = false;

        for (int i = 0; i < n; i++) {
            maxHeap.offer(score[i]);
            scoreIndexMap.put(score[i], i);
        }
        if (isTest) {
            System.out.println("score: " + Arrays.toString(score) + "\nmaxHeap: " + maxHeap + "\nscoreIndexMap: " + scoreIndexMap);
        }

        int count = 0;
        while (!maxHeap.isEmpty()) {
            int root = maxHeap.poll();
            int index = scoreIndexMap.get(root);
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

            if (isTest) {
                System.out.println("answer so far: " + Arrays.toString(answer));
            }
        }

        if (isTest) {
            System.out.println("answer: " + Arrays.toString(answer));
        }
        return answer;
    }
}