// Question: https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/description/

class MaxSumOfAPairWithEqualSumOfDigits {
    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        boolean isTest = false;
        int maximumSum = -1;

        for (int number: nums) {
            PriorityQueue<Integer> maxHeap;
            int digitSum = 0;
            int numberCopy = number;

            while (numberCopy > 0) {
                digitSum += numberCopy % 10;
                numberCopy /= 10;
            }
            map.computeIfAbsent(digitSum, k -> new PriorityQueue<>(Collections.reverseOrder())).offer(number);
        }
        if (isTest) {
            System.out.println("map:");
            for (Map.Entry<Integer, PriorityQueue<Integer>> e: map.entrySet()) {
                System.out.println(" * " + e.getKey() + " -> " + e.getValue());
            }
        }

        for (Map.Entry<Integer, PriorityQueue<Integer>> e: map.entrySet()) {
            if (e.getValue().size() < 2) {
                continue;
            }
            PriorityQueue<Integer> minHeap = e.getValue();
            int sum = 0;
            for (int i = 0; i < 2; i++) {
                sum += minHeap.poll();
            }
            maximumSum = Math.max(maximumSum, sum);
        }
        if (isTest) {
            System.out.println("---------------------------------\nmaximumSum: " + maximumSum);
        }

        return maximumSum;
    }
}