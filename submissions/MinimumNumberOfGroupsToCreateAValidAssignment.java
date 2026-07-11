// Question: https://leetcode.com/problems/minimum-number-of-groups-to-create-a-valid-assignment/description/

class MinimumNumberOfGroupsToCreateAValidAssignment {
    private Map<Integer, Integer> map;

    public int minGroupsForValidAssignment(int[] balls) {
        int n = balls.length;
        int smallestSize = n;
        map = new HashMap<>();

        for (int e: balls) {
            map.put(e, 1 + map.getOrDefault(e, 0));
        }
        for (int key: map.keySet()) {
            smallestSize = Math.min(map.get(key), smallestSize);
        }

        for (int size = smallestSize; size >= 1; size--) {
            int totalGroups = formGroups(size);
            if (totalGroups > 0) {
                return totalGroups;
            }
        }

        return n;
    }

    private int formGroups(int size) {
        int result = 0;
        int next = size + 1;

        for (int value: map.values()) {
            int totalGroups = value / next;
            int remainder = value % next;

            if (remainder == 0) {
                result += totalGroups;

            } else if (totalGroups >= size - remainder) {
                result += totalGroups + 1;

            } else {
                return 0;
            }

        }

        return result;
    }
}
