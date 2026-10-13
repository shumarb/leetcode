// Question: https://leetcode.com/problems/sum-of-beauty-in-the-array/description/

class SumOfBeautyInTheArray {
    public int sumOfBeauties(int[] nums) {
        boolean isTest = false;
        int maximum = nums[0];
        int n = nums.length;
        int result = 0;
        int[] suffix = new int[n];

        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.min(nums[i], suffix[i + 1]);
        }
        if (isTest) {
            System.out.println("nums:   " + Arrays.toString(nums) + "\nsuffix: " + Arrays.toString(suffix));
            System.out.println("-----------------------------------------------");
        }

        for (int i = 1; i < n - 1; i++) {
            int beauty = 0;
            int element = nums[i];

            if (maximum < element && element < suffix[i + 1]) {
                beauty = 2;

            } else if (nums[i - 1] < element && element < nums[i + 1]) {
                beauty = 1;
            }

            if (isTest) {
                System.out.println(" * index: " + i + " | element: " + element + " | beauty: " + beauty);
            }

            maximum = Math.max(element, maximum);
            result += beauty;
        }
        if (isTest) {
            System.out.println("-----------------------------------------------\nresult: " + result);
        }

        return result;
    }
}
