// Question: https://leetcode.com/problems/minimum-capacity-box/description/

class MinimumCapacityBox {
    public int minimumIndex(int[] capacity, int itemSize) {
        boolean isTest = false;
        int index = -1;
        int minimumCapacity = Integer.MAX_VALUE;

        for (int i = 0; i < capacity.length; i++) {
            if (capacity[i] >= itemSize && capacity[i] < minimumCapacity) {
                index = i;
                minimumCapacity = capacity[i];
            }
        }
        if (isTest) {
            System.out.println("minimumCapacity >= " + itemSize + ": " + minimumCapacity + "\nindex: " + index);
        }

        return index;
    }
}