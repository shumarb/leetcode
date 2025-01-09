// Question: https://leetcode.com/problems/third-maximum-number/

class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        boolean t = false;
        for (int n: nums) {
            if (!set.contains(n)) {
                minHeap.offer(n);
                // This ensures heap remains at size 3 at end of every iteration
                if (minHeap.size() > 3) {
                    minHeap.poll();
                }
            }
            set.add(n);
        }
        if (t) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("set: " + set);
            System.out.println("minHeap: " + minHeap);
        }

        // If minHeap is of size 3, then root is 3rd distinct
        // otherwise, reduce the heap to size 1 to get the maximum
        if (minHeap.size() == 3) {
            return minHeap.peek();
        } else {
            while (minHeap.size() != 1) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}