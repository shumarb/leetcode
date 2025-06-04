// Question: https://leetcode.com/problems/maximum-product-after-k-increments/description/

class MaximumProductAfterKIncrements {
    public int maximumProduct(int[] nums, int k) {
        long maximumProduct = 1;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        boolean isTest = false;

        for (int number: nums) {
            minHeap.offer(number);
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nk: " + k);
            display(minHeap);
        }

        while (k-- > 0) {
            minHeap.offer(1 + minHeap.poll());
            if (isTest) {
                display(minHeap);
            }
        }
        if (isTest) {
            System.out.println("after k iterations.");
            display(minHeap);
        }

        while (!minHeap.isEmpty()) {
            maximumProduct = (maximumProduct * minHeap.poll()) % 1000000007;
        }
        if (isTest) {
            System.out.println("maximum product: " + maximumProduct);
        }

        return (int) maximumProduct;
    }

    private void display(PriorityQueue<Integer> minHeap) {
        System.out.println("min heap:" + minHeap);
        System.out.println("------------------------------------------------------------------------");
    }
}