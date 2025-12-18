// Question: https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/description/

class NumberOfPairsOfStringsWithConcatenationEqualToTarget {
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> map = new HashMap<>();
        boolean isTest = false;
        int result = 0;

        for (String e: nums) {
            map.put(e, 1 + map.getOrDefault(e, 0));
        }
        if (isTest) {
            System.out.println("map: " + map);
            System.out.println("-------------------------------------------");
        }

        for (String prefix: nums) {
            if (prefix.length() > target.length() || !target.startsWith(prefix)) {
                continue;
            }

            String suffix = target.substring(prefix.length());
            if (!map.containsKey(suffix)) {
                continue;
            }
            if (isTest) {
                System.out.println("prefix: " + prefix + " -> suffix: " + suffix);
                System.out.println("-------------------------------------------");
            }

            // 1. If prefix == suffix, get count - 1 to prevent counting of self-pairs.
            int count = prefix.equals(suffix) ? map.get(suffix) - 1 : map.get(suffix);
            result += count;
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}