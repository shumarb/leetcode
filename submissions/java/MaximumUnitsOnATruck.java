// Question: https://leetcode.com/problems/maximum-units-on-a-truck/description/

class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        boolean isTest = false;
        int maximumTotalUnits = 0;
        List<int[]> list = new ArrayList<>();

        for (int[] entry: boxTypes) {
            list.add(entry);
        }
        list.sort((a, b) -> Integer.compare(b[1], a[1]));

        for (int i = 0; i < list.size(); i++) {
            int[] entry = list.get(i);
            while (truckSize != 0) {
                maximumTotalUnits += entry[1];
                entry[0]--;
                truckSize--;
                if (entry[0] == 0) {
                    break;
                }
            }
        }

        return maximumTotalUnits;
    }
}