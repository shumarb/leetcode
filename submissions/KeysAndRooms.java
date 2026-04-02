// Question: https://leetcode.com/problems/keys-and-rooms/description/

class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isKeyTaken = new boolean[rooms.size()];
        boolean isTest = false;
        int largest = 0;

        if (isTest) {
            System.out.println("before, isKeyTaken: " + Arrays.toString(isKeyTaken));
            System.out.println("-------------------------------------------------------");
        }

        isKeyTaken[0] = true;
        for (int key: rooms.get(0)) {
            if (!isKeyTaken[key]) {
                isKeyTaken[key] = true;
                queue.offer(key);
            }
        }
        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println(" * queue: " + queue);
            }

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int currentKey = queue.poll();
                isKeyTaken[currentKey] = true;

                for (int key: rooms.get(currentKey)) {
                    if (!isKeyTaken[key]) {
                        queue.offer(key);
                    }
                }
            }
        }

        if (isTest) {
            System.out.println("-------------------------------------------------------");
            System.out.println("after, isKeyTaken: " + Arrays.toString(isKeyTaken));
        }
        for (int i = 0; i < isKeyTaken.length; i++) {
            if (!isKeyTaken[i]) {
                return false;
            }
        }

        return true;
    }
}
