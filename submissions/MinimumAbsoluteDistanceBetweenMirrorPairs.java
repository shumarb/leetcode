// Question: https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/description/

class MinimumAbsoluteDistanceBetweenMirrorPairs {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        boolean isTest = false;
        int n = nums.length;
        int result = Integer.MAX_VALUE;

        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
        }
        for (int i = 0; i < n; i++) {
            int current = nums[i];
            int reverse = getReverse(current);

            if (map.containsKey(current)) {
                if (isTest) {
                    System.out.println("-------------------------\nfound @ i: " + i);
                    System.out.println(" * current: " + current + "\n * reverse: " + reverse + "\n * map: " + map);
                }

                result = Math.min(Math.abs(i - map.get(current)), result);
            }

            map.put(reverse, i);
        }
        if (isTest) {
            System.out.println("-------------------------\nmap: " + map + "\nresult: " + result);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int getReverse(int n) {
        int result = 0;

        while (n > 0) {
            result = result * 10 + n % 10;
            n /= 10;
        }

        return result;
    }
}
