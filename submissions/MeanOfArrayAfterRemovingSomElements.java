// Question: https://leetcode.com/problems/mean-of-array-after-removing-some-elements/description/

class MeanOfArrayAfterRemovingSomElements {
    public double trimMean(int[] arr) {
        double average = 0;
        int n = arr.length;
        int countRemovals = (int) (0.05 * n);

        arr = sort(arr);
        for (int i = countRemovals; i < n - countRemovals; i++) {
            average += arr[i];
        }

        return average / (double) (n - countRemovals * 2.0);
    }

    private int[] sort(int[] arr) {
        int[] frequency;
        int j = 0;
        int largest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            largest = Math.max(arr[i], largest);
        }
        frequency = new int[largest + 1];

        for (int number: arr) {
            frequency[number]++;
        }
        for (int i = 0; i <= largest; i++) {
            while (frequency[i]-- > 0) {
                arr[j++] = i;
            }
        }

        return arr;
    }
}