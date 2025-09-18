// Question: https://leetcode.com/problems/find-the-least-frequent-digit/description/

class FindTheLeastFrequentDigit {
    public int getLeastFrequentDigit(int n) {
        boolean isTest = false;
        int[] frequency = new int[10];
        int maximumFrequency = Integer.MAX_VALUE;
        int nCopy = n;
        int smallest = -1;

        while (nCopy > 0) {
            frequency[nCopy % 10]++;
            nCopy /= 10;
        }
        for (int i = 0; i <= 9; i++) {
            if (frequency[i] == 0) {
                continue;
            }
            if (frequency[i] < maximumFrequency) {
                maximumFrequency = frequency[i];
                smallest = i;
            }
        }
        if (isTest) {
            System.out.println("n: " + n + "\nfrequency: " + Arrays.toString(frequency));
            System.out.println("maximumFrequency: " + maximumFrequency + "\nsmallest: " + smallest);
        }

        return smallest;
    }
}