// Question: https://leetcode.com/problems/mean-of-array-after-removing-some-elements/description/

class MeanOfArrayAfterRemovingSomElements {
    public double trimMean(int[] arr) {
        double mean = 0;
        int n = arr.length;
        int countRemovals = (int) (0.05 * n);

        Arrays.sort(arr);
        for (int i = countRemovals; i < n - countRemovals; i++) {
            mean += arr[i];
        }

        return mean / (double) (n - countRemovals * 2.0);
    }
}