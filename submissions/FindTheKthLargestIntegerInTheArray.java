// Question: https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/description/

class FindTheKthLargestIntegerInTheArray {
    public String kthLargestNumber(String[] nums, int k) {
        boolean isTest = false;
        if (isTest) {
            System.out.println("k: " + k + "\nbefore: " + Arrays.toString(nums));
        }
        Arrays.sort(nums, (a, b) -> Integer.compare(a.length(), b.length()) == 0 ? a.compareTo(b) : Integer.compare(a.length(), b.length()));
        if (isTest) {
            System.out.println("\nafter: " + Arrays.toString(nums));
        }

        return nums[nums.length - k];
    }
}