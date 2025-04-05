// Question: https://leetcode.com/problems/summary-ranges/description/

class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int len = nums.length;

        while (i < len) {
            int start = nums[i];
            while (i + 1 < len && nums[i + 1] == 1 + nums[i]) {
                i++;
            }
            if (start == nums[i]) {
                result.add(String.valueOf(start));
            } else {
                result.add(start + "->" + nums[i]);
            }
            i++;
        }

        return result;
    }
}