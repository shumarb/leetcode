// Question: https://leetcode.com/problems/keys-and-rooms/description/

class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isKeyTaken = new boolean[rooms.size()];
        boolean isTest = false;
        int countKeysTaken = 1; // Room 0 is unlocked, so it's key is taken.

        if (isTest) {
            System.out.println("before, isKeyTaken: " + Arrays.toString(isKeyTaken));
            System.out.println("-------------------------------------------------------");
        }

        isKeyTaken[0] = true;
        for (int key: rooms.get(0)) {
            if (!isKeyTaken[key]) {
                countKeysTaken++;
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
                if (!isKeyTaken[currentKey]) {
                    countKeysTaken++;
                    isKeyTaken[currentKey] = true;
                }

                for (int key: rooms.get(currentKey)) {
                    if (!isKeyTaken[key]) {
                        queue.offer(key);
                    }
                }
            }
        }
        if (isTest) {
            System.out.println("-------------------------------------------------------");
            System.out.println("after, isKeyTaken: " + Arrays.toString(isKeyTaken) + "\ncountKeysTaken: " + countKeysTaken);
        }

        return countKeysTaken == rooms.size();
    }
}
