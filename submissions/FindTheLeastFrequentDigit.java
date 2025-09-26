// Question: https://leetcode.com/problems/find-the-least-frequent-digit/description/

class FindTheLeastFrequentDigit {
    public int getLeastFrequentDigit(int n) {
        boolean isTest = false;
        int[] frequency = new int[10];
        int minimumFrequency = Integer.MAX_VALUE;
        int nCopy = n;
        int smallest = -1;

        while (nCopy > 0) {
            frequency[nCopy % 10]++;
            nCopy /= 10;
        }
        for (int i = 0; i <= 9; i++) {
            int count = frequency[i];
            if (count > 0 && count < minimumFrequency) {
                minimumFrequency = count;
                smallest = i;
            }
        }
        if (isTest) {
            System.out.println("n: " + n + "\nfrequency: " + Arrays.toString(frequency));
            System.out.println("minimumFrequency: " + minimumFrequency + "\nsmallest: " + smallest);
        }

        return smallest;
    }
}