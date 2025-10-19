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

            if (!map.containsKey(digitSum)) {
                maxHeap = new PriorityQueue<>();
                maxHeap.offer(number);
            } else {
                maxHeap = map.get(digitSum);
                maxHeap.offer(number);
                if (maxHeap.size() > 2) {
                    maxHeap.poll();
                }
                map.remove(digitSum);
            }
            map.put(digitSum, maxHeap);
        }

        for (Map.Entry<Integer, PriorityQueue<Integer>> e: map.entrySet()) {
            if (e.getValue().size() < 2) {
                continue;
            }
            PriorityQueue<Integer> minHeap = e.getValue();
            int sum = 0;
            while (!minHeap.isEmpty()) {
                sum += minHeap.poll();
            }
            maximumSum = Math.max(maximumSum, sum);
        }
        if (isTest) {
            System.out.println("map:");
            for (Map.Entry<Integer, PriorityQueue<Integer>> e: map.entrySet()) {
                System.out.println(" * " + e.getKey() + " -> " + e.getValue());
            }
            System.out.println("---------------------------------\nmaximumSum: " + maximumSum);
        }

        return maximumSum;
    }
}