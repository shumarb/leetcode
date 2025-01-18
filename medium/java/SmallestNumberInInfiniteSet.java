// Question: https://leetcode.com/problems/smallest-number-in-infinite-set/description/

class SmallestInfiniteSet {
    private boolean[] freq;

    public SmallestInfiniteSet() {
        freq = new boolean[1001];
        Arrays.fill(freq, true);
    }

    public int popSmallest() {
        for (int i = 1; i <= 1000; i++) {
            if (freq[i]) {
                freq[i] = false;
                return i;
            }
        }
        return -1;
    }

    public void addBack(int num) {
        if (!freq[num]) {
            freq[num] = true;
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
