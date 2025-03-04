// Question: https://leetcode.com/problems/maximum-units-on-a-truck/description/

class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        boolean isTest = false;
        int maximumUnits = 0;

        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        if (isTest) {
            System.out.println("truck size: " + truckSize);
            System.out.println("sorted boxTypes:");
            for (int[] entry: boxTypes) {
                System.out.println(" * [quantity: " + entry[0] + ", units: " + entry[1] + "]");
            }
        }

        for (int[] entry: boxTypes) {
            while (truckSize != 0) {
                maximumUnits += entry[1];
                entry[0]--;
                truckSize--;
                if (entry[0] == 0) {
                    break;
                }
            }
        }

        return maximumUnits;
    }
}