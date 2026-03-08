// Question: https://leetcode.com/problems/find-unique-binary-string/description/

class FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder result = new StringBuilder();
        int n = nums[0].length();

        for (int i = 0; i < n; i++) {
            result.append(nums[i].charAt(i) == '1' ? '0' : '1');
        }

        return result.toString();
    }
}