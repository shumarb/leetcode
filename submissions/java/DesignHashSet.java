// Question: https://leetcode.com/problems/design-hashset/description/

class MyHashSet {

    private List<Integer> hashSet;

    public MyHashSet() {
        hashSet = new ArrayList<>();
    }

    public void add(int key) {
        if (hashSet == null) {
            hashSet = new ArrayList<>();
        }
        if (!hashSet.contains(key)) {
            hashSet.add(key);
        }
    }

    public void remove(int key) {
        if (hashSet == null) {
            hashSet = new ArrayList<>();
        }
        for (int i = 0; i < hashSet.size(); i++) {
            if (hashSet.get(i) == key) {
                hashSet.remove(i);
            }
        }
    }

    public boolean contains(int key) {
        if (hashSet == null) {
            hashSet = new ArrayList<>();
        }
        return hashSet.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */