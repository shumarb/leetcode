// Question: https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/description/

class DivideArrayInSetsOfKConsecutiveNumbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        boolean isTest = false;
        int n = nums.length;

        // 1. Can't form sets of k if nums.length is not divisible by k.
        if (n % k != 0) {
            return false;
        }

        for (int number: nums) {
            map.merge(number, 1, Integer::sum);
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

                map.compute(current, (key, value) -> value == 1 ? null : value - 1);
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
