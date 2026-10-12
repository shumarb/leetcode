// Question: https://leetcode.com/problems/sum-of-beauty-in-the-array/description/

class SumOfBeautyInTheArray {
    public int sumOfBeauties(int[] nums) {
        boolean isTest = false;
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        long result = 0;

        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(nums[i], prefix[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.min(nums[i], suffix[i + 1]);
        }
        if (isTest) {
            System.out.println("prefix: " + Arrays.toString(prefix) + "\nnums:   " + Arrays.toString(nums) + "\nsuffix: " + Arrays.toString(suffix));
            System.out.println("-----------------------------------------------");
        }

        for (int i = 1; i < n - 1; i++) {
            int beauty = 0;
            int element = nums[i];

            if (prefix[i - 1] < element && element < suffix[i + 1]) {
                beauty = 2;

            } else if (nums[i - 1] < element && element < nums[i + 1]) {
                beauty = 1;
            }

            if (isTest) {
                System.out.println(" * index: " + i + " | element: " + element + " | beauty: " + beauty);
            }

            result += beauty;
        }
        if (isTest) {
            System.out.println("-----------------------------------------------\nresult: " + result);
        }

        return (int) result;
    }
}
