// Question: https://leetcode.com/problems/count-the-number-of-good-subarrays/description/

class CountTheNumberOfGoodSubarrays {
    public long countGood(int[] nums, int k) {
        Map<Long, Long> map = new HashMap<>();
        boolean isTest = false;
        int left = 0;
        long countValidPairs = 0;
        long result = 0;

        if (isTest) {
            System.out.println("k: " + k + "\nnums: " + Arrays.toString(nums) + "\n-----------------------------------------");
        }
        for (int right = 0; right < nums.length; right++) {
            long incoming = nums[right];
            long frequency = map.getOrDefault(incoming, 0l);
            long countOldPairs = frequency * (frequency - 1l) / 2l;

            // 1. Frequency is increased after adding incoming to window.
            map.merge(incoming, 1l, Long::sum);
            long countNewPairs = ++frequency * (frequency - 1l) / 2l;

            countValidPairs += (countNewPairs - countOldPairs);

            while (countValidPairs >= k) {
                if (isTest) {
                    System.out.println(" * indices: [" + left + ", " + right + "] | map: " + map + " | subarray: " + Arrays.toString(Arrays.copyOfRange(nums, left, right + 1)));
                }

                long remove = nums[left++];
                frequency = map.get(remove);
                countOldPairs = frequency * (frequency - 1l) / 2l;

                // 2. Frequency is decreased after removing remove to window.
                countNewPairs = --frequency * (frequency - 1l) / 2l;
                if (frequency == 0) {
                    map.remove(remove);
                } else {
                    map.put(remove, frequency);
                }

                countValidPairs += (countNewPairs - countOldPairs);
            }

            result += left;
        }
        if (isTest) {
            System.out.println("-----------------------------------------\nresult: " + result);
        }

        return result;
    }
}
