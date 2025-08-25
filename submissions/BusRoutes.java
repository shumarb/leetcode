// Question: https://leetcode.com/problems/bus-routes/description/

class BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // 1. Edge case: target is source.
        if (source == target) {
            return 0;
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();
        boolean isTest = false;

        for (int i = 0; i < routes.length; i++) {
            int bus = i;
            int[] route = routes[i];
            for (int stop: route) {
                Set<Integer> set = map.containsKey(stop) ? map.get(stop) : new HashSet<>();
                set.add(bus);
                map.put(stop, set);
            }
        }
        if (isTest) {
            System.out.println("map:");
            for (Map.Entry<Integer, Set<Integer>> e: map.entrySet()) {
                System.out.println(" * " + e.getKey() + " -> " + e.getValue());
            }
            System.out.println("------------------------------------");
        }

        // 2. Edge case: Neither source or target is in map.
        if (!map.containsKey(source) || !map.containsKey(target)) {
            return -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seenStops = new HashSet<>();
        boolean[] isBusSeen = new boolean[routes.length];
        int level = 0;

        /**
         3.  Each BFS level represents one bus ride.

         While the queue of stops is non-empty,
         1. For each stop at the current level:
             1. Mark it as visited.
             2. For each bus passing through the stop:
                 1. If the bus has not been marked as used, mark it as use.
                 2. For each bus on this route:
                     1. If it is target, return current level (number of buses used).
                     2. If it has not been visited, add it to the queue.

         Return -1 is the target is not encountered whist traversing the queue.
         */
        queue.add(source);
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            if (isTest) {
                System.out.println(" * level: " + level + ", queue: " + queue);
            }

            for (int i = 0; i < size; i++) {
                int currentStop = queue.poll();
                seenStops.add(currentStop);

                for (int bus: map.get(currentStop)) {
                    if (!isBusSeen[bus]) {
                        isBusSeen[bus] = true;
                        for (int stop: routes[bus]) {
                            if (stop == target) {
                                return level;
                            } else if (seenStops.add(stop)) {
                                queue.offer(stop);
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }
}