// Question: https://leetcode.com/problems/hand-of-straights/description/

class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        boolean isTest = false;
        int len = hand.length;

        if (len % groupSize != 0) {
            return false;
        }
        for (int number: hand) {
            map.put(number, 1 + map.getOrDefault(number, 0));
        }
        if (isTest) {
            System.out.println("hand: " + Arrays.toString(hand) + ", groupSize: " + groupSize);
            System.out.println("map: " + map);
        }

        while (!map.isEmpty()) {
            int count = groupSize;
            int current = map.firstKey();
            if (isTest) {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println(" * current: " + current);
                System.out.println(" * before: " + map);
            }

            while (count > 0) {
                if (!map.containsKey(current)) {
                    return false;
                }
                map.put(current, map.get(current) - 1);
                if (map.get(current) == 0) {
                    map.remove(current);
                }
                current++;
                count--;
            }

            if (isTest) {
                System.out.println(" * after: " + map);
            }
        }

        return true;
    }
}