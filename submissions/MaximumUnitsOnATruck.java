// Question: https://leetcode.com/problems/maximum-units-on-a-truck/description/

class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        boolean isTest = false;
        int maximumUnits = 0;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[1], a[1])
        );
        for (int[] entry: boxTypes) {
            maxHeap.offer(entry);
        }

        if (isTest) {
            System.out.println("truckSize: " + truckSize);
            System.out.println("max heap:");
            for (int[] entry: maxHeap) {
                System.out.println(" * " + Arrays.toString(entry));
            }
            System.out.println("-------------------------------------------------");
        }

        while (truckSize > 0 && !maxHeap.isEmpty()) {
            int[] entry = maxHeap.poll();
            if (isTest) {
                System.out.println(" * entry: " + Arrays.toString(entry));
            }

            /**
             1.  For current entry,
                 if the truck has enough space to load all boxes,
                 add all the boxes to truck (reducing truck size by number of boxes),
                 and increase maximum units by (number of boxes * units per box).
             */
            if (truckSize > entry[0]) {
                maximumUnits += (entry[0] * entry[1]);

                /**
                    2.  For current entry,
                        the number of current boxes exceeds the truck's size,
                        so add as much current boxes as we can (meaning load truckSize of boxes from current boxes).
                 */
            } else {
                maximumUnits += (truckSize * entry[1]);
            }

            /**
                3.  Reduce the truck size by number of boxes added at current iteration.
             */
            truckSize -= entry[0];
        }

        return maximumUnits;
    }
}