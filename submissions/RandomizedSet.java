// Question: https://leetcode.com/problems/insert-delete-getrandom-o1/description/

class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        /**
         to preserve O(1) operation,
         1. swap last element with element to be removed in list
         2. update last element's mapping in the map to be {element-last index of list}
         3. Remove val from the list and map

         [9 5 7 1] ==> remove 7
         {9=0, 5=1, 7=2, 1=3}

         [9 5 1 7]
         {9=0, 5=1, 1=2, 7=3}

         [9 5 1]
         {9=0, 5=1, 1=2}
         */
        int valIndex = map.get(val);
        int lastElement = list.get(list.size() - 1);

        list.set(valIndex, lastElement);
        map.put(lastElement, valIndex);

        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */