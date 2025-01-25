// Question: https://leetcode.com/problems/find-good-days-to-rob-the-bank/description/

class FindGoodDaysToRobTheBank {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> indices = new ArrayList<>();
        int n = security.length;

        // 1. Impossible to find a day with time days before and after it.
        if (time > n) {
            return indices;
        }

        // 2. Every day is a good day to rob.
        if (time == 0) {
            for (int i = 0; i < n; i++) {
                indices.add(i);
            }
            return indices;
        }

        // 3. Precomputation of number of days before an index that is non-decreasing,
        // and number of days after an index that is non-increasing
        // then check that for a given index, it has >= time elements in non-increasing order before it,
        // and >= time elements in non-decreasing order after it.
        int[] nonIncreasingDays = new int[n];
        int[] nonDecreasingDays = new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                nonIncreasingDays[i] = 1 + nonIncreasingDays[i - 1];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                nonDecreasingDays[i] = 1 + nonDecreasingDays[i + 1];
            }
        }

        boolean isTest = false;
        if (isTest) {
            System.out.println("security: " + Arrays.toString(security) + ", time: " + time);
            System.out.println("nonIncreasingDays: " + Arrays.toString(nonIncreasingDays));
            System.out.println("nonDecreasingDays: " + Arrays.toString(nonDecreasingDays));
        }

        for (int i = time; i < n - time; i++) {
            if (nonIncreasingDays[i] >= time && nonDecreasingDays[i] >= time) {
                indices.add(i);
            }
        }

        return indices;
    }
}