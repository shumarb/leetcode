// Question: https://leetcode.com/problems/minimum-discards-to-balance-inventory/description/

class MinimumDiscardsToBalanceInventory {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int[] count;
        int largest = 0;
        int n = arrivals.length;
        int result = 0;
        boolean[] isKept = new boolean[n];
        boolean isTest = false;

        for (int e: arrivals) {
            largest = Math.max(e, largest);
        }
        count = new int[largest + 1];
        isKept = new boolean[n];

        for (int i = 0; i < w; i++) {
            int incoming = arrivals[i];
            if (count[incoming] < m) {
                count[incoming]++;
                isKept[i] = true;
            } else {
                result++;
            }
        }
        if (isTest) {
            System.out.println(" * index [0" + ", " + (w - 1) + "] | window: " + Arrays.toString(Arrays.copyOfRange(arrivals, 0, w)) + " | count: " + Arrays.toString(count));
        }

        for (int i = w; i < arrivals.length; i++) {
            // 1. Remove only if this arrival was kept.
            if (isKept[i - w]) {
                count[arrivals[i - w]]--;
            }

            int incoming = arrivals[i];
            if (count[incoming] < m) {
                count[incoming]++;
                isKept[i] = true;
            } else {
                result++;
            }

            if (isTest) {
                System.out.println(" * index [" + (i - w + 1) + ", " + i + "] | window: " + Arrays.toString(Arrays.copyOfRange(arrivals, i - w + 1, i + 1)) + " | count: " + Arrays.toString(count));
            }
        }

        return result;
    }
}
