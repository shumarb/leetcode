// Question: https://leetcode.com/problems/number-of-equivalent-domino-pairs/description/

class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean isTest = false;
        int count = 0;

        for (int[] entry: dominoes) {
            int first = entry[0];
            int second = entry[1];
            int key = Math.min(first, second) * 10 + Math.max(first, second);
            map.put(key, 1 + map.getOrDefault(key, 0));
        }

        if (isTest) {
            System.out.println("dominoes:");
            for (int[] entry: dominoes) {
                System.out.println(" * " + Arrays.toString(entry));
            }
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("map:");
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                System.out.println(" * " + entry.getKey() + " --> " + entry.getValue());
            }
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int value = entry.getValue();
            if (value > 1) {
                count += value * (value - 1) / 2;
            }
        }

        return count;
    }
}