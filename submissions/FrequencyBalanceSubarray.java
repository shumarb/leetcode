// Question: https://leetcode.com/problems/frequency-balance-subarray/description/

class FrequencyBalanceSubarray {
    public int getLength(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        int result = 1;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            int maximumFrequency = 1;
            int totalElements = 1;

            map.put(nums[i], 1);
            if (isTest) {
                System.out.println("-----------------------------------------------------------------------------------------\ni: " + i);
                System.out.println(" * incoming: " + nums[i] + " | map: " + map + " | maximumFrequency: " + maximumFrequency + " | totalElements: " + totalElements);
            }

            for (int j = i + 1; j < n; j++) {
                int incoming = nums[j];
                totalElements++;
                map.put(incoming, 1 + map.getOrDefault(incoming, 0));
                maximumFrequency = Math.max(maximumFrequency, map.get(incoming));

                // 1. Maximum frequency must be even for formula to be applied.
                if (maximumFrequency % 2 == 1) {
                    continue;
                }
                if (isTest) {
                    System.out.println("\n * incoming: " + nums[j] + " | map: " + map + " | maximumFrequency: " + maximumFrequency + " | totalElements: " + totalElements);
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
        if (map.size() == 1) {
            return true;
        }

        int halfCount = 0;
        int maximumCount = 0;

        for (int key: map.keySet()) {
            int value = map.get(key);
            if (value == maximumFrequency) {
                maximumCount++;
            } else if (value == maximumFrequency / 2) {
                halfCount++;
            } else {
                return false;
            }
        }

        return halfCount > 0 && maximumCount > 0;
    }
}
