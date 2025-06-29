// Question: https://leetcode.com/problems/find-unique-binary-string/description/

class FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder result = new StringBuilder();
        boolean isTest = false;

        for (int i = 0; i < nums.length; i++) {
            result.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        if (isTest) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("result: " + result.toString());
        }

        return result.toString();
    }
}