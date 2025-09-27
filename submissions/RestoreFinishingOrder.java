// Question: https://leetcode.com/problems/restore-finishing-order/description/

class RestoreFinishingOrder {
    public int[] recoverOrder(int[] order, int[] friends) {
        PriorityQueue<Integer> heap;
        boolean isTest = false;
        int[] map = new int[order.length + 1];
        int[] result = new int[friends.length];
        int i = 0;

        heap = new PriorityQueue<>(
                (a, b) -> Integer.compare(map[a], map[b])
        );
        Arrays.fill(map, -1);

        for (; i < order.length; i++) {
            map[order[i]] = i;
        }
        for (int friend: friends) {
            heap.add(friend);
        }
        i = 0;
        while (!heap.isEmpty()) {
            result[i++] = heap.poll();
        }
        if (isTest) {
            System.out.println("map: " + Arrays.toString(map));
            System.out.println("heap: " + heap + "\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}