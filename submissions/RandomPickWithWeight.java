// Question: https://leetcode.com/problems/random-pick-with-weight/description/

class RandomPickWithWeight {
    private int sum = 0;
    private int[] w;
    private Queue<Integer> queue;
    private boolean isTest = false;

    public RandomPickWithWeight(int[] w) {
        queue = new LinkedList<>();
        this.w = w;

        for (int number: w) {
            sum += number;
        }

        for (int i = 0; i < w.length; i++) {
            int index = i;
            int count = w[i] * 100 / sum;
            for (int j = 0; j < count; j++) {
                queue.offer(index);
            }
        }

        if (isTest) {
            System.out.println("w: " + Arrays.toString(w));
            System.out.println("queue: " + queue);
        }
    }

    public int pickIndex() {
        if (queue.isEmpty()) {
            return 0;
        }
        int index = queue.poll();
        queue.offer(index);
        return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */