// Question: https://leetcode.com/problems/reduce-array-size-to-the-half/description/

class ReduceArraySizeToTheHalf {
    public int minSetSize(int[] arr) {
        boolean isTest = false;
        int minSetSize = 0;

        int maximum = arr[0];
        for (int number: arr) {
            maximum = Math.max(maximum, number);
        }
        if (isTest) {
            System.out.println("arr: " + Arrays.toString(arr) + ", maximum: " + maximum);
        }

        int[] numberFrequency = new int[maximum + 1];
        for (int number: arr) {
            numberFrequency[number]++;
        }
        if (isTest) {
            System.out.println("numberFrequency: " + Arrays.toString(numberFrequency));
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[1], a[1]) == 0 ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1])
        );
        for (int i = 0; i < numberFrequency.length; i++) {
            if (numberFrequency[i] > 0) {
                maxHeap.offer(new int[] {i, numberFrequency[i]});
            }
        }
        if (isTest) {
            System.out.println("max heap:" );
            for (int[] entry: maxHeap) {
                System.out.println(" * number: " + entry[0] + " --> frequency: " + entry[1]);
            }
        }

        int size = arr.length;
        while (size > arr.length / 2) {
            int[] entry = maxHeap.poll();
            minSetSize++;
            size -= entry[1];
        }

        return minSetSize;
    }
}