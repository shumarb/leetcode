// Question: https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/description/

class FindTheMaximumNumberOfElementsInSubset {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        boolean isTest = false;
        int result = 1;

        for (long key: nums) {
            map.put(key, 1 + map.getOrDefault(key, 0));
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nmap: " + map);
            System.out.println("-------------------------------------------");
        }

        for (long start: map.keySet()) {
            if (start == 1l) {
                int count = map.get(1l);
                if (count % 2 == 0) {
                    count--;
                }

                result = Math.max(count, result);
                continue;
            }

            long current = start;
            int longestSubsetLength = 1;

            while (map.containsKey(current * current) && map.get(current) >= 2) {
                longestSubsetLength += 2;
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
