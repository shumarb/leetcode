// Question: https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/description/

class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        boolean isTest = false;
        int n = groupSizes.length;

        for (int i = 0; i < n; i++) {
            int key = groupSizes[i];
            int value = i;
            map.putIfAbsent(key, new LinkedList<>());
            map.get(key).offer(value);
        }
        if (isTest) {
            System.out.println("map:");
            for (Map.Entry<Integer, Queue<Integer>> e: map.entrySet()) {
                System.out.println(" * " + e.getKey() + " -> " + e.getValue());
            }
        }
        for (Map.Entry<Integer, Queue<Integer>> e: map.entrySet()) {
            List<Integer> entry = new ArrayList<>();
            Queue<Integer> queue = e.getValue();
            int size = e.getKey();
            while (!queue.isEmpty()) {
                for (int i = 0; i < size; i++) {
                    entry.add(queue.poll());
                }
                result.add(new ArrayList<>(entry));
                entry.clear();
            }
        }
        if (isTest) {
            System.out.println("---------------------------------------------");
            System.out.println("result:");
            for (List<Integer> e: result) {
                System.out.println(" * " + e);
            }
        }

        return result;
    }
}