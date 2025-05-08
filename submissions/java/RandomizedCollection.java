// Question: https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/description/

class RandomizedCollection {
    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;
    private Random random;
    private boolean isTest = false;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        boolean isNew = !map.containsKey(val);
        list.add(val);

        map.putIfAbsent(val, new HashSet<>());
        map.get(val).add(list.size() - 1);

        if (isTest) {
            System.out.println("insert: " + val);
            display();
        }
        return isNew;
    }

    public boolean remove(int val) {
        // 1. False when val is not in map or val is in map but its set is empty
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            return false;
        }

        // 2. Retrieve an index containing val (can be any if more than 1 instance of val in list)
        int removalIndex = map.get(val).iterator().next();
        int lastIndex = list.size() - 1;
        int lastElement = list.get(lastIndex);
        if (isTest) {
            System.out.println("remove: " + val + ", removalIndex: " + removalIndex);
            display();
        }

        // 3. Remove removalIndex from val's set
        map.get(val).remove(removalIndex);

        // 4. Swap elements at removalIndex and last index if val is not last element
        if (removalIndex != lastIndex) {
            // 4.1. Set index of val to be removed as lastElement
            list.set(removalIndex, lastElement);

            // 4.2. Remove last index from lastElement's set of indices
            map.get(lastElement).remove(lastIndex);

            // 4.3. Add removalIndex to set of indices of lastElement
            map.get(lastElement).add(removalIndex);
        }

        // 5. Removal of val at last index
        list.remove(lastIndex);

        // 6. If val's set of indices is empty, val is not in list,
        // so remove its mapping from the map
        if (map.get(val).isEmpty()) {
            map.remove(val);
        }

        if (isTest) {
            System.out.println("after removal of " + val + " at index: " + removalIndex);
            display();
        }

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    private void display() {
        System.out.println("list: " + list);
        System.out.println("map:");
        for (Map.Entry<Integer, Set<Integer>> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
        System.out.println("-----------------------------");
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */