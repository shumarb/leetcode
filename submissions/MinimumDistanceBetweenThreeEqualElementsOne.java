// Question: https://leetcode.com/problems/minimum-distance-between-three-equal-elements-i/description/

class MinimumDistanceBetweenThreeEqualElementsOne {
    public int minimumDistance(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }

        List<Integer>[] map;
        boolean isTest = false;
        int largest = 0;
        int result = Integer.MAX_VALUE;

        for (int e: nums) {
            largest = Math.max(e, largest);
        }
        map = new ArrayList[largest + 1];
        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }

        for (int x = 0; x < nums.length; x++) {
            int element = nums[x];

            map[element].add(x);

            if (map[element].size() >= 3) {
                List<Integer> list = map[element];
                int n = list.size();
                int i = list.get(n - 3);
                int j = list.get(n - 2);
                int k = list.get(n - 1);
                int distance = Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i);
                result = Math.min(distance, result);
            }
        }
        if (isTest) {
            System.out.println("map:");
            for (int i = 0; i < map.length; i++) {
                System.out.println(" * " + i + ": " + map[i]);
            }
            System.out.println("---------------------------------\nresult: " + result);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
