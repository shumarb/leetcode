// Question: https://leetcode.com/problems/type-of-triangle/description/

class TypeOfTriangle {
    public String triangleType(int[] nums) {
        Arrays.sort(nums);

        if (nums[0] + nums[1] <= nums[2]) {
            return "none";
        }

        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        }

        if (nums[0] == nums[1] || nums[0] == nums[2] || nums[1] == nums[2]) {
            return "isosceles";
        }

        return "scalene";
    }
}