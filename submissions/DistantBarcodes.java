// Question: https://leetcode.com/problems/distant-barcodes/description/

class DistantBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        // 1. Edge case: Array with single element, so return array.
        if (barcodes.length == 1) {
            return barcodes;
        }

        /**
         2.  Count frequency of each element,
             and populate max heap of elements
             ordered in descending order of frequency.
         */
        int maximum = barcodes[0];
        for (int number: barcodes) {
            maximum = Math.max(maximum, number);
        }
        int[] numberFrequency = new int[maximum + 1];
        for (int number: barcodes) {
            numberFrequency[number]++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[1], a[1])
        );
        for (int i = 1; i <= maximum; i++) {
            if (numberFrequency[i] > 0) {
                maxHeap.offer(new int[] {i, numberFrequency[i]});
            }
        }

        /**
             3.  While element has at least 2 elements,
                 obtain first 2, and fill next 2 elements of barcodes
                 as one of each. This ensures all adjacent pairs
                 contain unique numbers.

                 Then decrement frequency of each number used by 1,
                 and if its remainding frequency > 1, add into the heap:
                 [element, (element frequency - 1)].
         */
        int index = 0;
        while (maxHeap.size() > 1) {
            int[] first = maxHeap.poll();
            int[] second = maxHeap.poll();
            barcodes[index++] = first[0];
            barcodes[index++] = second[0];
            first[1]--;
            second[1]--;
            if (first[1] > 0) {
                maxHeap.offer(new int[] {first[0], first[1]});
            }
            if (second[1] > 0) {
                maxHeap.offer(new int[] {second[0], second[1]});
            }
        }

        /**
         4.  Edge case: Heap contains single element,
             so set last element as this element.
         */
        if (!maxHeap.isEmpty()) {
            barcodes[index] = maxHeap.peek()[0];
        }

        return barcodes;
    }
}