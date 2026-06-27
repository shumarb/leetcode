// Question: https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/description/

class FindTheMaximumNumberOfElementsInSubset {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        boolean isTest = false;
        int result = 1;

        for (long key: nums) {
            map.put(key, 1 + map.getOrDefault(key, 0));
        }
        if (map.containsKey(1l)) {
            int value = map.get(1l);
            if (value % 2 == 0) {
                value--;
            }
            result = Math.max(result, value);
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nmap: " + map);
            System.out.println("-------------------------------------------");
        }

        for (long start: map.keySet()) {
            if (start == 1l) {
                continue;
            }

            long current = start;
            int longestSubsetLength = 0;

            while (true) {
                Integer count = map.get(current);

                if (count == null) {
                    longestSubsetLength--;
                    break;
                }

                // 1. last element in chain
                if (count == 1) {
                    longestSubsetLength++;
                    break;
                }

                longestSubsetLength += 2;

                // 2. Check to prevent overflow.
                if (current > (long) Math.sqrt(Long.MAX_VALUE)) {
                    break;
                }

                current *= current;
            }
            if (isTest) {
                System.out.println("start: " + start + " -> longestSubsetLength: " + longestSubsetLength);
            }
            result = Math.max(longestSubsetLength, result);
        }
        if (isTest) {
            System.out.println("-------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
