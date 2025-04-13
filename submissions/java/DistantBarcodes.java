// Question: https://leetcode.com/problems/distant-barcodes/description/

class DistantBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        if (barcodes.length == 1) {
            return barcodes;
        }

        boolean isTest = false;
        int maximum = barcodes[0];

        for (int number: barcodes) {
            maximum = Math.max(maximum, number);
        }
        int[] numberFrequency = new int[maximum + 1];
        for (int number: barcodes) {
            numberFrequency[number]++;
        }

        int current = getMostFrequentElement(numberFrequency, -1);
        barcodes[0] = current;
        numberFrequency[current]--;
        for (int i = 1; i < barcodes.length; i++) {
            current = getMostFrequentElement(numberFrequency, barcodes[i - 1]);
            barcodes[i] = current;
            numberFrequency[current]--;
        }

        return barcodes;
    }

    private int getMostFrequentElement(int[] numberFrequency, int banned) {
        int maximumFrequency = 0;
        int candidate = -1;

        for (int i = 0; i < numberFrequency.length; i++) {
            if (i != banned && numberFrequency[i] > maximumFrequency) {
                maximumFrequency = numberFrequency[i];
                candidate = i;
            }
        }

        return candidate;
    }
}