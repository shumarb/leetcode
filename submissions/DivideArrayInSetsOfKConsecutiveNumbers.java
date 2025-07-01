// Question: https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/description/

class DivideArrayInSetsOfKConsecutiveNumbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        boolean isTest = false;
        int len = nums.length;

        // 1. Can't form sets of k if nums.length is not divisible by k.
        if (len % k != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int number: nums) {
            map.put(number, 1 + map.getOrDefault(number, 0));
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums) + "\nmap: " + map);
        }

        while (!map.isEmpty()) {
            int count = k;
            int current = map.firstKey();
            if (isTest) {
                System.out.println("--------------------------------------------");
                System.out.println("count: " + count + "\ncurrent: " + current);
                System.out.println(" * before, map: " + map);
            }
            while (count > 0) {
                if (!map.containsKey(current)) {
                    return false;
                }
                map.put(current, map.get(current) - 1);
                if (map.get(current) == 0) {
                    map.remove(current);
                }
                count--;
                current++;
            }
            if (isTest) {
                System.out.println(" * after, map: " + map);
            }
        }

        return true;
    }
}