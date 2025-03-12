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

        int countIntegers = 0;
        for (int i = 0; i < numberFrequency.length; i++) {
            if (numberFrequency[i] > 0) {
                countIntegers++;
            }
        }

        int[][] maxHeap = new int[countIntegers][2];
        int j = 0;
        for (int i = 0; i < numberFrequency.length; i++) {
            if (numberFrequency[i] > 0) {
                maxHeap[j++] = new int[] {i, numberFrequency[i]};
            }
        }
        Arrays.sort(maxHeap, (a, b) -> Integer.compare(b[1], a[1]) == 0 ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));
        if (isTest) {
            System.out.println("maxHeap:");
            for (int[] row: maxHeap) {
                System.out.println(" * number: " + row[0] + " --> " + row[1]);
            }
        }

        int arraySize = arr.length;
        j = 0;
        while (arraySize > arr.length / 2) {
            arraySize -= maxHeap[j++][1];
            minSetSize++;
        }
        if (isTest) {
            System.out.println("min set size: " + minSetSize);
        }

        return minSetSize;
    }
}