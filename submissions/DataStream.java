// Question: https://leetcode.com/problems/find-consecutive-integers-from-a-data-stream/description/

class DataStream {
    private int count;
    private int k;
    private int value;

    public DataStream(int value, int k) {
        this.count = 0;
        this.k = k;
        this.value = value;
    }

    public boolean consec(int num) {
        if (num == value) {
            count++;
        } else {
            count = 0;
        }

        return count >= k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */