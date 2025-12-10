// Question: https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/description/

class RestoreTheArrayFromAdjacentPairs {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        boolean isTest = false;
        int[] result;
        int j = 0;
        int source = -1;
        int total = 0;

        for (int[] e: adjacentPairs) {
            int first = e[0];
            int second = e[1];
            map.putIfAbsent(first, new ArrayList<>());
            map.putIfAbsent(second, new ArrayList<>());
            map.get(first).add(second);
            map.get(second).add(first);
        }
        for (Map.Entry<Integer, List<Integer>> e: map.entrySet()) {
            if (e.getValue().size() == 1) {
                source = e.getKey();
                break;
            }
        }
        result = new int[map.size()];
        stack.push(source);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                int top = stack.pop();
                visited.add(top);
                result[j++] = top;
                List<Integer> neighbours = map.get(top);
                for (int e: neighbours) {
                    if (!visited.contains(e)) {
                        stack.push(e);
                    }
                }
            }
        }
        if (isTest) {
            System.out.println("map:");
            for (Map.Entry<Integer, List<Integer>> e: map.entrySet()) {
                System.out.println(" * " + e.getKey() + " -> " + e.getValue());
            }
            System.out.println("-----------------------------------\nsource: " + source + "\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}