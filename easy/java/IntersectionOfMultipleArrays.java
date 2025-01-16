// Question: https://leetcode.com/problems/intersection-of-multiple-arrays/description/

class IntersectionOfMultipleArrays {
    private boolean t = false;

    public List<Integer> intersection(int[][] nums) {
        List<Integer> ans = new ArrayList<> ();

        int max = getMax(nums);
        if (t) {
            System.out.println("max: " + max);
        }

        int[] freq = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            count(freq, nums[i]);
        }
        if (t) {
            System.out.println("freq: " + Arrays.toString(freq));
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == nums.length) {
                ans.add(i);
            }
        }
        if (t) {
            System.out.println("ans: " + ans);
        }

        return ans;
    }

    private void count(int[] freq, int[] n) {
        for (int x: n) {
            if (t) {
                System.out.println("freq: " + Arrays.toString(freq) + ",\nn: " + Arrays.toString(n));
            }
            freq[x]++;
        }
    }

    private int getMax(int[][] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                max = Math.max(max, nums[i][j]);
            }
        }
        return max;
    }
}