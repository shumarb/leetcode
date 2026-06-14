// Question: https://leetcode.com/problems/frequency-balance-subarray/description/

class FrequencyBalanceSubarray {
    public int getLength(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        int result = 1;

        if (n == 1) {
            return n;
        }

        for (int i = 0; i < n - 1; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            int maximumFrequency = 0;
            int totalElements = 0;

            for (int j = i; j < n; j++) {
                int incoming = nums[j];
                int value = 1 + map.getOrDefault(incoming, 0);

                map.put(incoming, value);
                maximumFrequency = Math.max(maximumFrequency, value);
                totalElements++;

                // 1. Maximum frequency must be even for formula to be applied.
                if (maximumFrequency % 2 == 1) {
                    continue;
                }

                if (isTest) {
                    System.out.println("\n * incoming: " + incoming + " | map: " + map + " | maximumFrequency: " + maximumFrequency + " | totalElements: " + totalElements);
                }
                if (isBalanced(map, maximumFrequency)) {
                    if (isTest) {
                        System.out.println(" * balanced");
                    }

                    result = Math.max(result, totalElements);
                }
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------------------------------------------------------\nresult: " + result);
        }

        return result;
    }

    private boolean isBalanced(Map<Integer, Integer> map, int maximumFrequency) {
        // 2. Array contains only 1 distinct value.
        if (map.size() == 1) {
            return true;
        }

        int halfCount = 0;
        int halfFrequency = maximumFrequency / 2;
        int maximumCount = 0;

        for (int value: map.values()) {
            if (value == maximumFrequency) {
                maximumCount++;

            } else if (value == halfFrequency) {
                halfCount++;

            } else {
                return false;
            }
        }

        return halfCount > 0 && maximumCount > 0;
    }
}
