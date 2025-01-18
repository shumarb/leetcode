// Question: https://leetcode.com/problems/most-frequent-even-element/description/

class MostFrequentEvenElements {
    public int mostFrequentEven(int[] nums) {
        boolean t = false;
        Map<Integer, Integer> map = new HashMap<> ();
        for (int x: nums) {
            if ((x % 2) == 0) {
                map.put(x, 1 + (map.getOrDefault(x, 0)));
            }
        }
        if (t) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("map: " + map);
        }

        int freqKey = Integer.MAX_VALUE;
        int freqVal = Integer.MIN_VALUE;
        if (!map.isEmpty()) {
            for(Map.Entry<Integer, Integer> e: map.entrySet()) {
                Map.Entry<Integer, Integer> curr = e;
                if (t) {
                    System.out.println(curr);
                }
                if (e.getValue() > freqVal) {
                    freqKey = e.getKey();
                    freqVal = e.getValue();
                }
                if (e.getValue() == freqVal && e.getKey() < freqKey) {
                    freqKey = e.getKey();
                }
            }
        }
        if (t) {
            System.out.println("freqKey: " + freqKey + ", freqVal: " + freqVal);
        }

        return map.isEmpty() ? -1 : freqKey;
    }
}