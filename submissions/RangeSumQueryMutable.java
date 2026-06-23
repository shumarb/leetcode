// Question:

class RangeSumQueryMutable {
    private boolean isTest;
    private int[] bit;
    private int[] nums;
    private int n;

    public NumArray(int[] nums) {
        isTest = false;
        n = nums.length;
        this.bit = new int[n + 1];
        this.nums = nums;

        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }

        if (isTest) {
            print("initialisation:");
            System.out.println("------------------");
        }
    }

    private void print(String s) {
        System.out.println(s + "\n * nums: " + Arrays.toString(nums));
        System.out.println(" * bit: " + Arrays.toString(bit));
    }

    private void add(int index, int difference) {
        while (index <= n) {
            bit[index] += difference;
            index += index & -index;
        }
    }

    public void update(int index, int val) {
        int difference = val - nums[index];
        nums[index] = val;

        // 1. Add difference to values at indices [index + 1, n - 1].
        add(index + 1, difference);
    }

    public int sumRange(int left, int right) {
        return prefixSum(right + 1) - prefixSum(left);
    }

    private int prefixSum(int index) {
        int result = 0;

        while (index > 0) {
            result += bit[index];
            index -= index & -index;
        }

        return result;
    }
}
