// Question: https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/

class HowManyNumbersAreSmallerThanTheCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<> ();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                map.put(num, i);
            }
        }
        for (int i = 0; i < ans.length; i++) {
            int num = ans[i];
            ans[i] = map.get(num);
        }
        return ans;
    }

}
