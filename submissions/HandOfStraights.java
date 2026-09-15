// Question: https://leetcode.com/problems/hand-of-straights/description/

class HandOfStraightsclass {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        boolean isTest = false;
        int n = hand.length;

        if (n % groupSize != 0) {
            return false;
        }
        for (int number: hand) {
            map.merge(number, 1, Integer::sum);
        }
        if (isTest) {
            System.out.println("hand: " + Arrays.toString(hand) + ", groupSize: " + groupSize + "\nmap: " + map);
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

                map.compute(current, (key, value) -> value == 1 ? null : value - 1);
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
