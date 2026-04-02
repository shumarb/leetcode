// Question: https://leetcode.com/problems/keys-and-rooms/description/

class KeysAndRooms {
    private int countVisitedRooms;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] isVisited = new boolean[rooms.size()];
        boolean isTest = false;
        countVisitedRooms = 0;

        if (isTest) {
            System.out.println("before, isVisited: " + Arrays.toString(isVisited));
        }
        dfs(0, rooms, isVisited);
        if (isTest) {
            System.out.println("after, isVisited: " + Arrays.toString(isVisited) + "\ncountVisitedRooms: " + countVisitedRooms);
        }

        return countVisitedRooms == rooms.size();
    }

    private void dfs(int id, List<List<Integer>> rooms, boolean[] isVisited) {
        isVisited[id] = true;
        countVisitedRooms++;

        for (int key: rooms.get(id)) {
            if (!isVisited[key]) {
                dfs(key, rooms, isVisited);
            }
        }
    }
}
