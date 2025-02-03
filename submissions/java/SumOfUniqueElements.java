// Question: https://leetcode.com/problems/sum-of-unique-elements/description/

class SumOfUniqueElements {
    public int sumOfUnique(int[] nums) {
        boolean t = false;
        int max = getMax(nums);
        if (t) {
            System.out.println("nums: " + Arrays.toString(nums) + ", max: " + max);
        }
        int[] freq = new int[max + 1];
        for (int x: nums) {
            freq[x]++;
        }
        if (t) {
            System.out.println("freq: " + Arrays.toString(freq));
        }

        int sum = 0;
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 1) {
                sum += i;
            }
        }
        if (t) {
            System.out.println("sum: " + sum);
        }
        return sum;
    }

    private int getMax(int[] n) {
        int max = n[0];
        for (int x: n) {
            max = Math.max(max, x);
        }
        return max;
    }
}