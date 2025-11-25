// Question: https://leetcode.com/problems/count-nice-pairs-in-an-array/description/

class CountNicePairsInAnArray {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean isTest = false;
        int result = 0;

        for (int e: nums) {
            int key = e - getReverse(e);
            int value = map.getOrDefault(key, 0);
            result = (result + value) % 1000000007;
            map.put(key, 1 + value);
        }
        if (isTest) {
            System.out.println("map: " + map + "\nresult: " + result);
        }

        return result;
    }

    private int getReverse(int e) {
        int reverse = 0;

        while (e > 0) {
            reverse *= 10;
            reverse += e % 10;
            e /= 10;
        }

        return reverse;
    }
}