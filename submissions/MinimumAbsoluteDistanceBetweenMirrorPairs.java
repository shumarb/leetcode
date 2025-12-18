// Question: https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/description/

class MinimumAbsoluteDistanceBetweenMirrorPairs {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean isTest = false;
        int n = nums.length;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int current = nums[i];
            int reverse = reverse(current);

            if (isTest) {
                System.out.println("i: " + i + " | current: " + current + " -> reverse: " + reverse);
                System.out.println(" * before, map: " + map);
            }
            if (map.containsKey(current)) {
                int index = map.get(current);
                int value = Math.abs(index - i);
                if (isTest) {
                    System.out.println(" ** found " + current + " | index: " + index);
                    System.out.println(" *** before, result: " + result + ", value: " + value);
                }
                result = Math.min(result, Math.abs(index - i));
                if (isTest) {
                    System.out.println(" *** after, result: " + result);
                }
            }

            map.put(reverse, i);
            if (isTest) {
                System.out.println(" * after, map: " + map);
                System.out.println("--------------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("map: " + map + "\nresult: " + result);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int reverse(int n) {
        int reverse = 0;

        while (n > 0) {
            reverse *= 10;
            reverse += n % 10;
            n /= 10;
        }
        return reverse;
    }
}