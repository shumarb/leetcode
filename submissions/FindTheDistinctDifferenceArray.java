// Question: https://leetcode.com/problems/find-the-distinct-difference-array/description/

class FindTheDistinctDifferenceArray {
    public int[] distinctDifferenceArray(int[] nums) {
        int len = nums.length;
        int[] difference = new int[len];
        boolean isTest = false;

        int[] prefix = populatePrefix(nums);
        int[] suffix = populateSuffix(nums);
        if (isTest) {
            System.out.println("prefix: " + Arrays.toString(prefix));
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("suffix: " + Arrays.toString(suffix));
        }

        for (int i = 0; i < len; i++) {
            difference[i] = prefix[i] - suffix[i];
        }
        return difference;
    }

    private int[] populateSuffix(int[] nums) {
        int len = nums.length;
        int[] suffix = new int[len];
        Set<Integer> set = new HashSet<> ();
        for (int i = len - 2; i >= 0; i--) {
            set.add(nums[i + 1]);
            suffix[i] = set.size();
        }
        return suffix;
    }

    private int[] populatePrefix(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        Set<Integer> set = new HashSet<> ();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
            result[i] = set.size();
        }

        return result;
    }
}