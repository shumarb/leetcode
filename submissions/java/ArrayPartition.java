// Question: https://leetcode.com/problems/array-partition/description/

class ArrayPartition {
    public int arrayPairSum(int[] nums) {
        int maximizedSum = 0;
        boolean isTest = false;
        Arrays.sort(nums);

        if (isTest) {
            System.out.println("sorted nums: " + Arrays.toString(nums));
        }

        for (int i = 0; i < nums.length; i += 2) {
            if (isTest) {
                System.out.println(" * indices: " + i + ", " + (i + 1));
                System.out.println(" * elements: " + nums[i] + ", " + nums[i + 1]);
                System.out.println(" * minimum: " + nums[i] + " --> adding to maximizedSum");
                System.out.println("-------------------------------------------------------------");
            }
            maximizedSum += nums[i];
        }
        if (isTest) {
            System.out.println("maximized sum: " + maximizedSum);
        }

        return maximizedSum;
    }
}